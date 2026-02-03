package org.main.lists;

public class Queue {
    DoubleLinkedList doubleLinkedList;

    public Queue() {
        doubleLinkedList = new DoubleLinkedList();
    }

    public void addQueue(Object o) {
        doubleLinkedList.addFirst(o);
    }

    public Object peek() {
        return doubleLinkedList.getLast();
    }

    public Object remove() {
        return doubleLinkedList.removeLast();
    }
}
