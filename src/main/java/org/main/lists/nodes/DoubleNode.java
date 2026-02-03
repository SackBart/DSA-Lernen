package org.main.lists.nodes;

public class DoubleNode {
    private DoubleNode next;
    private DoubleNode prev;
    private Object obj;

    public DoubleNode (final Object obj, DoubleNode next, DoubleNode prev) {
        this.obj = obj;
        this.next = next;
        this.prev = prev;
    }

    public DoubleNode getNext() {
        return next;
    }

    public DoubleNode getPrev() {
        return prev;
    }

    public Object getObj() {
        return obj;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }

    public void setPrev(DoubleNode prev) {
        this.prev = prev;
    }
}
