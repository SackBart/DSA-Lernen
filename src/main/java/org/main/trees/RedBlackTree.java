package org.main.trees;

import org.main.trees.nodes.RBNode;

/**
 * RedBlack is a binary tree used to represent 2-3-4 Trees. Nodes can be red and black.
 * Whenever a black node has one or two red children, they're within one node on the 2-3-4 tree.
 *
 * 2-3-4 Trees: https://www.youtube.com/watch?v=K1a2Bk8NrYQ&t=296s
 * RedBlack Trees: https://www.youtube.com/watch?v=ZgtAONMxpwY
 *
 * @param <K> Whatever comparable I guess
 */
public class RedBlackTree<K extends Comparable<K>> {
    private RBNode<K> root;

    public RedBlackTree() {
        root = null;
    }

    private void split(RBNode<K> node, RBNode<K> parent, RBNode<K> grand, RBNode<K> great) {
        // Color the children black
        if (node.getLeft() != null) node.getLeft().setRed(false);
        if (node.getRight() != null) node.getRight().setRed(false);

        // Case 1: 4-key node is root: Do nothing more
        if (node == root) return;

        // Set node's color to red
        node.setRed(true);

        // Case 2 4-key node is underneath a 2-key node OR 4-key node is underneath a 3-key node: Do nothing more
        if (!parent.isRed()) return;

        if ((grand.getLeft() == parent) == (parent.getLeft() == node)) {
            // Case 3b: Obvious to going on the same side (either left or right only)
            replaceChild(great, grand, rotate(grand));
            grand.setRed(true);
            parent.setRed(false);
        } else {
            // Case 3c: Obvious to going on different sides
            replaceChild(grand, parent, rotate(parent));
            replaceChild(great, grand, rotate(grand));
            grand.setRed(true);
            node.setRed(false);
        }
    }

    public boolean insert(K key) {
        if (root == null) {
            root = new RBNode<>(key);
            return true;
        }

        // Inheritance: great -> grand -> parent -> node
        RBNode<K> parent = null;
        RBNode<K> grand = null;
        RBNode<K> great = null;
        RBNode<K> node = root;

        while (node != null) {
            if (node.getLeft() != null && node.getLeft().isRed() && // if the node is a 4-key node
                node.getRight() != null && node.getRight().isRed()) {
                split(node, parent, grand, great);
            }
            great = grand;
            grand = parent;
            parent = node;
            int cmp = parent.getKey().compareTo(key);
            if (cmp == 0) {
                return false;
            } else if (cmp > 0) { // parent's key is bigger than the key to insert so put it on the left
                node = node.getLeft();
            } else {
                node = node.getRight(); // parent's key is smaller than the key to insert so put it on the right
            }
        }

        // Link the new node to the tree
        node = new RBNode<>(key);
        if (parent.getKey().compareTo(key) > 0)
            parent.setLeft(node);
        else
            parent.setRight(node);

        /*
            Currently the new node is black but with the following split command it will be painted red
            and will be put up to its parent node.
         */
        split(node, parent, grand, great);

        return true;
    }

    private RBNode<K> rotate(RBNode<K> n) {
        // Pre-Condition: On rotation, exact one child must be red
        boolean leftIsRed = n.getLeft() != null && n.getLeft().isRed();
        boolean rightIsRed = n.getRight() != null && n.getRight().isRed();
        if (leftIsRed == rightIsRed)
            throw new IllegalArgumentException();

        // We rotate the child upwards
        if (leftIsRed)
            return rotateRight(n);
        else
            return rotateLeft(n);
    }

    private RBNode<K> rotateLeft(RBNode<K> n) {
        RBNode<K> tmp = n.getRight();
        n.setRight(tmp.getLeft());
        tmp.setLeft(n);
        return tmp;
    }

    private RBNode<K> rotateRight(RBNode<K> n) {
        RBNode<K> tmp = n.getLeft();
        n.setLeft(tmp.getRight());
        tmp.setRight(n);
        return tmp;
    }

    public void replaceChild(RBNode<K> node, RBNode<K> oldChild, RBNode<K> newChild) {
        /*
            This Function can also be used to replace the root
            by inserting node = null
        */
        if (node == null) {
            if (root != oldChild)
                throw new IllegalArgumentException();
            root = newChild;
        }
        else if (node.getLeft() == oldChild)
            node.setLeft(newChild);
        else if (node.getRight() == oldChild)
            node.setRight(newChild);
        else
            throw new IllegalArgumentException();
    }

    public RBNode<K> getRoot() {
        return root;
    }
}
