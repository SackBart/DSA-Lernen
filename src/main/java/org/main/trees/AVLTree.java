package org.main.trees;

import org.main.trees.nodes.AVLNode;
import org.main.trees.nodes.Node;


/**
 * The AVL Tree is an extension to the BinarySearch tree, but it enforces a rule so that
 * the tree stays balanced.
 *
 * "The difference between the height of the right subset and the height of the left subset is x <= |1|"
 *
 * If it reaches -2 or 2, the case will be observed and it will either do a normal rotation or a double rotation
 * See for more info: <a href="https://www.geeksforgeeks.org/dsa/introduction-to-avl-tree/">...</a>
 *
 * @param <K> A comparable
 */
public class AVLTree<K extends Comparable<K>> {
    private AVLNode<K> root;

    public void insert(K k) {
        System.out.println("insert(" + k + ")"); // Output for visualisation
        if (root == null)
            root = new AVLNode<>(k);
        else
            root = insertNode(root, k);
    }

    private AVLNode<K> insertNode(AVLNode<K> n, K k) {
        int cmp = n.getKey().compareTo(k);
        if (cmp == 0) {
            // Key already exists, nothing to do so insert it on the right
        } else if (cmp < 0) {
            // Cmp < 0: n key is smaller than k
            if (n.getRight() != null) {
                // Insert it on the right subtree (recursive)
                n.setRight(insertNode(n.getRight(), k));
            } else {
                // Create a new leaf node on the right
                n.setRight(new AVLNode<>(k));
            }
            // The height of the subtree could have changed
            n.updateHeight();
            // Rebalance if needed
            if (n.getBalance() < -1) {
                // Rebalance
                if (n.getRight().getBalance() < 0) {
                    // Case 1: Left Rotation
                    // Output for visualisation:
                    System.out.println("L("
                            + n.getRight().getKey() + ","
                            + n.getKey() + ")");
                    n = rotateLeft(n);
                } else {
                    // Case 2: Double-rotation (right-left)
                    // Output for visualisation:
                    System.out.println("DR("
                            + n.getRight().getLeft().getKey() + ","
                            + n.getRight().getKey() + ","
                            + n.getKey() + ")");
                    n.setRight(rotateRight(n.getRight()));
                    n = rotateLeft(n);
                }
            }
        } else {
            // Cmp > 0: n key is bigger than k
            // Insert on the left (symmetrical)
            if (n.getLeft() != null) {
                // Insert it on the left subtree (recursive)
                n.setLeft(insertNode(n.getLeft(), k));
            } else {
                // Create new leaf node on the left
                n.setLeft(new AVLNode<>(k));
            }
            // Height of the subtree could have changed
            n.updateHeight();
            // Rebalance if needed
            if (n.getBalance() > 1) {
                // Rebalance
                if (n.getLeft().getBalance() > 0) {
                    // Case 1: Rotate right
                    // Output for visualisation:
                    System.out.println("R("
                            + n.getLeft().getKey() + ","
                            + n.getKey() + ")");
                    n = rotateRight(n);
                } else {
                    // Fall 2: Double-rotation (left-right)
                    // Output for visualisation:
                    System.out.println("DL("
                            + n.getLeft().getRight().getKey() + ","
                            + n.getLeft().getKey() + ","
                            + n.getKey() + ")");
                    n.setLeft(rotateLeft(n.getLeft()));
                    n = rotateRight(n);
                }
            }
        }

        return n;
    }

    private AVLNode<K> rotateLeft(AVLNode<K> n) {
        AVLNode<K> tmp = n.getRight();
        n.setRight(tmp.getLeft());
        n.updateHeight();
        tmp.setLeft(n);
        tmp.updateHeight();
        return tmp;
    }

    private AVLNode<K> rotateRight(AVLNode<K> n) {
        AVLNode<K> tmp = n.getLeft();
        n.setLeft(tmp.getRight());
        n.updateHeight();
        tmp.setRight(n);
        tmp.updateHeight();
        return tmp;
    }
}
