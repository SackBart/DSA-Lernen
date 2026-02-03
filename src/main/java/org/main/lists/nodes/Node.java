package org.main.lists.nodes;

public class Node<T> {
    private Node<T> next;
    private T obj;

    public Node(final T obj, final Node<T> next) {
        this.next = next;
        this.obj = obj;
    }

    public Node<T> getNext() { return next; }

    public void setNext(final Node<T> next) { this.next = next; }

    public T getObj() { return obj; }

    public void setObj(final T obj) { this.obj = obj; }
}
