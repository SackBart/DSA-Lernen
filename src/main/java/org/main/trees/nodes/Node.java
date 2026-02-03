package org.main.trees.nodes;

public abstract class Node<K extends Comparable<K>> {
    public abstract Node<K> getLeft();
    public abstract Node<K> getRight();
    public abstract void setLeft(Node<K> n);
    public abstract void setRight(Node<K> n);
    public abstract K getKey();
}
