package org.main.trees.nodes;

public class AVLNode<K extends Comparable<K>> {
    private int height;
    private K key;
    private AVLNode<K> left;
    private AVLNode<K> right;

    public AVLNode(K key) {
        this.key = key;
        this.height = 1;
    }

    public AVLNode<K> getLeft() {
        return left;
    }
    public void setLeft(AVLNode<K> left) {
        this.left = left;
    }
    public AVLNode<K> getRight() {
        return right;
    }
    public void setRight(AVLNode<K> right) {
        this.right = right;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public K getKey() {
        return key;
    }
    public void setKey(K key) {
        this.key = key;
    }

    public void updateHeight() {
        int l = (left == null) ? 0 : left.getHeight();
        int r = (right == null) ? 0 : right.getHeight();
        height = Math.max(l, r) + 1;
    }

    public int getBalance() {
        int l =  (left == null) ? 0 : left.getHeight();
        int r = (right == null) ? 0 : right.getHeight();
        return l - r;
    }
}
