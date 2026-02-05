package org.main.trees.nodes;

public class RBNode<K extends Comparable<K>> {
    private K key;
    private RBNode<K> right;
    private RBNode<K> left;
    private boolean red = false;

    public RBNode(K key) {
        this.key = key;
    }

    public void setKey(RBNode<K> key) {
        this.key = key.key;
    }
    public void setLeft(RBNode<K> left) {
        this.left = left;
    }
    public void setRight(RBNode<K> right) {
        this.right = right;
    }
    public void setRed(boolean b) {
        this.red = b;
    }

    public K getKey() {
        return key;
    }
    public RBNode<K> getLeft() {
        return left;
    }
    public RBNode<K> getRight() {
        return right;
    }
    public boolean isRed() {
        return red;
    }
}
