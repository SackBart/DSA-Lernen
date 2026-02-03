package org.main.trees;

import org.main.trees.nodes.Node;
import org.main.trees.nodes.TreeNode;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;

    public BinarySearchTree() {
        root = null;
    }

    public Node<T> getRoot() {
        return root;
    }

    public Node<T> recursiveFindNode(Node<T> node, T k) {
        if (node == null) {
            return null;
        }
        int cmp = node.getKey().compareTo(k);
        if (cmp == 0) {
            return node;
        } else if (cmp > 0) {
            return recursiveFindNode(node.getLeft(), k);
        } else {
            return recursiveFindNode(node.getRight(), k);
        }
    }

    public boolean insert(T k) {
        if (root == null) {
            root = new TreeNode<>(k);
            return true;
        }
        Node<T> parent = null;
        Node<T> child = root;

        /*
         * i = a.compareTo(b)
         * i < 0: a < b
         * i = 0: a = b
         * i > 0: a > b
         */

        // Find the node with the value k
        while (child != null) {
            parent = child;
            int cmp = parent.getKey().compareTo(k);
            if (cmp == 0) {
                return false;
            } else if (cmp > 0) {
                child = child.getLeft();
            } else {
                child = child.getRight();
            }
        }

        // Put the node to the left if it's less than the parent, otherwise put it on the right
        TreeNode<T> newNode = new TreeNode<>(k);
        if (parent.getKey().compareTo(k) > 0) {
            parent.setLeft(newNode);
        } else {
            parent.setRight(newNode);
        }
        return true;
    }

    public boolean delete(T k) {
        Node<T> parent = null;
        Node<T> node = root;

        // Find the node with the value k
        while (node != null) {
            int cmp = node.getKey().compareTo(k);
            if (cmp == 0) {
                break;
            }
            parent = node;
            if (cmp > 0) {
                node = node.getLeft();
            } else {
                node = node.getRight();
            }
        }
        if (node == null) {
            return false;
        }

        // Find the successor node
        Node<T> successor;
        // Case 1: The node is a leaf node
        if (node.getLeft() == null && node.getRight() == null ) {
            successor = null;
        // Case 2a: The node only has a left Child
        } else if (node.getRight() == null) {
            successor = node.getLeft();
        // Case 2b: The node only has a right child
        } else if (node.getLeft() == null) {
            successor = node.getRight();
        // Case 3: The node is an internal node (Left and right child)
        } else {
            Node<T> tmp = node;
            successor = node.getRight();
            // Get the smallest number of the subtree
            while (successor.getLeft() != null) {
                tmp = successor; // tmp will be the parent of successor
                successor = tmp.getLeft();
            }
            // Put the left of the node on the successor which will later then be brought up
            successor.setLeft(node.getLeft());
            if (tmp != node) {
                tmp.setLeft(successor.getRight());
                successor.setRight(node.getRight());
            }
        }

        if (root == node) {
            root = successor;
        } else if (parent.getLeft() == node) {
            parent.setLeft(successor);
        } else {
            parent.setRight(successor);
        }
        return true;
    }
}
