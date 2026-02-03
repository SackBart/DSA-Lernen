package org.main.lists.nodes;

public class Node {
    private Node next;
    private Object obj;

    public Node(final Object obj, final Node next) {
        this.next = next;
        this.obj = obj;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(final Node next) {
        this.next = next;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(final Object obj) {
        this.obj = obj;
    }
}
