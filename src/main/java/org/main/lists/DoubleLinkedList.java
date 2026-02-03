package org.main.lists;

import org.main.lists.nodes.DoubleNode;

public class DoubleLinkedList<T> {
    DoubleNode<T> head;
    DoubleNode<T> tail;

    public DoubleLinkedList() {
        head = null;
        tail = null;
    }

    private void addToEmptyList(T o) {
        this.head = new DoubleNode<>(o, null, null);
        this.tail = this.head;
    }

    public void addFirst(T o) {
        if (this.head == null) {
            this.addToEmptyList(o);
        } else {
            DoubleNode<T> newNode = new DoubleNode<>(o, null, null);
            newNode.setNext(this.head);
            this.head.setPrev(newNode);
            this.head = newNode;
        }
    }

    public void addLast(T o) {
        if (this.head == null) {
            this.addToEmptyList(o);
        } else {
            DoubleNode<T> newNode = new DoubleNode<>(o, null, null);
            newNode.setPrev(this.tail);
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
    }

    public T removeFirst() {
        if (this.head == null) {
            return null;
        }

        T o = this.head.getObj();
        this.head = this.head.getNext();
        return o;
    }

    public T removeLast() {
        if (this.tail == null) {
            return null;
        }

        T o = this.tail.getObj();
        this.tail = this.tail.getPrev();
        return o;
    }

    public T getFirst() {
        return head == null ? null : head.getObj();
    }

    public T getLast() {
        return tail == null ? null : tail.getObj();
    }
}
