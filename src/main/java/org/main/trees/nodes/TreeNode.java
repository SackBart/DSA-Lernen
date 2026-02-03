package org.main.trees.nodes;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreeNode<K extends Comparable<K>> extends Node {
    K key;
    Node<K> left = null;
    Node<K> right = null;

    // -- Constructor
    public TreeNode(K e) {
        key = e;
    }

    // -- Manipulators
    public Node<K> getLeft() { return left; }

    public Node<K> getRight() { return right; }

    public K getKey() { return key; }

    public void setLeft (Node n) { left = n; }

    public void setRight (Node n) { right = n; }

    // -- Print stuff
    public static <K extends Comparable<K>> void printInorder(Node<K> n) {
        if (n != null) {
            printInorder(n.getLeft());
            System.out.println(n.getKey());
            printInorder(n.getRight());
        }
    }

    public static <K extends Comparable<K>> void printPreorder(Node<K> n) {
        if (n != null) {
            System.out.println(n.getKey());
            printPreorder(n.getLeft());
            printPreorder(n.getRight());
        }
    }

    public static <K extends Comparable<K>> void printPostorder(Node<K> n) {
        if (n != null) {
            printPostorder(n.getLeft());
            printPostorder(n.getRight());
            System.out.println(n.getKey());
        }
    }

    public static <K extends Comparable<K>> void printLevelorder(Node<K> root) {
        if (root != null) {
            Queue<Node<K>> queue = new ArrayDeque<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                Node<K> n = queue.remove();
                if (n.getLeft() != null)
                    queue.add(n.getLeft());
                if (n.getRight() != null)
                    queue.add(n.getRight());
                System.out.println(n.getKey());
            }
        }
    }

    //-- More cool stuff
}
