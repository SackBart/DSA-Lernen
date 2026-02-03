package org.main.lists;

import org.main.lists.nodes.Node;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> {
    private Node<T> head;

    public LinkedList() {
        this.head = null;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void addFirst(final T obj) {
        Node<T> n = new Node<>(obj, head);
        head = n;
    }

    public void addLast(final T obj) {
        Node<T> n = new Node<>(obj, null);

        if (isEmpty()) {
            this.head = n;
            return;
        }

        Node<T> l = this.head;

        while (l.getNext() != null) {
            l = l.getNext();
        }
        l.setNext(n);
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        T obj = this.head.getObj();
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

        Node<T> l = head;
        while (l.getNext().getNext() != null) {
            l = l.getNext();
        }
        T obj = l.getNext().getObj();
        l.setNext(null);
        return obj;
    }

    private class ListIterator implements Iterator<Object> {
        private Node<T> current = null;

        public ListIterator() {
            this.current = head;
        }
        public boolean hasNext() {
            return this.current != null;
        }
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T obj = this.current.getObj();
            this.current = this.current.getNext();
            return obj;
        }
    }

    public Iterator iterator() {
        return new ListIterator();
    }
}
