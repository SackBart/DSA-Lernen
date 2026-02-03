package org.main.lists;

public class Stack {
    DoubleLinkedList doubleLinkedList;

    public Stack() {
        this.doubleLinkedList = new DoubleLinkedList();
    }

    public void push(Object o) {
        this.doubleLinkedList.addFirst(o);
    }

    public Object pop() {
        return this.doubleLinkedList.removeFirst();
    }

    public Object peek() {
        return this.doubleLinkedList.getFirst();
    }
}
