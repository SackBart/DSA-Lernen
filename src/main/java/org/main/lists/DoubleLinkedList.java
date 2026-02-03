package org.main.lists;

import org.main.lists.nodes.DoubleNode;

public class DoubleLinkedList {
    DoubleNode head;
    DoubleNode tail;

    public DoubleLinkedList() {
        head = null;
        tail = null;
    }

    private void addToEmptyList(Object o) {
        this.head = new DoubleNode(o, null, null);
        this.tail = this.head;
    }

    public void addFirst(Object o) {
        if (this.head == null) {
            this.addToEmptyList(o);
        } else {
            DoubleNode newNode = new DoubleNode(o, null, null);
            newNode.setNext(this.head);
            this.head.setPrev(newNode);
            this.head = newNode;
        }
    }

    public void addLast(Object o) {
        if (this.head == null) {
            this.addToEmptyList(o);
        } else {
            DoubleNode newNode = new DoubleNode(o, null, null);
            newNode.setPrev(this.tail);
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
    }

    public Object removeFirst() {
        if (this.head == null) {
            return null;
        }

        Object o = this.head.getObj();
        this.head = this.head.getNext();
        return o;
    }

    public Object removeLast() {
        if (this.tail == null) {
            return null;
        }

        Object o = this.tail.getObj();
        this.tail = this.tail.getPrev();
        return o;
    }

    public Object getFirst() {
        return head == null ? null : head.getObj();
    }

    public Object getLast() {
        return tail == null ? null : tail.getObj();
    }
}
