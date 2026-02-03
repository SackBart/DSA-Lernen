package org.main.lists;

import org.main.lists.nodes.Node;

public class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void addFirst(final Object obj) {
        Node n = new Node(obj, head);
        head = n;
    }

    public void addLast(final Object obj) {
        Node n = new Node(obj, null);

        if (isEmpty()) {
            this.head = n;
            return;
        }

        Node l = this.head;

        while (l.getNext() != null) {
            l = l.getNext();
        }
        l.setNext(n);
    }

    public Object removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Object obj = this.head.getObj();
        this.head = this.head.getNext();
        return obj;
    }

    public Object removeLast() {
        if (isEmpty()) {
            return null;
        }

        if (head.getNext() == null) {
            Object obj = head.getObj();
            head = null;
            return obj;
        }

        Node l = head;
        while (l.getNext().getNext() != null) {
            l = l.getNext();
        }
        Object obj = l.getNext().getObj();
        l.setNext(null);
        return obj;
    }
}
