package org.main.lists.nodes;

public class DoubleNode<T> {
    private DoubleNode<T> next;
    private DoubleNode<T> prev;
    private T obj;

    public DoubleNode (final T obj, DoubleNode<T> next, DoubleNode<T> prev) {
        this.obj = obj;
        this.next = next;
        this.prev = prev;
    }

    public DoubleNode<T> getNext() {
        return next;
    }

    public DoubleNode<T> getPrev() {
        return prev;
    }

    public T getObj() { return obj; }

    public void setObj(final T obj) { this.obj = obj; }

    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

    public void setPrev(DoubleNode<T> prev) {
        this.prev = prev;
    }
}
