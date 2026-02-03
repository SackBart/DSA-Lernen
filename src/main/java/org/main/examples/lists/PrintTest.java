package org.main.examples.lists;

import org.main.lists.LinkedList;

public class PrintTest {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.addFirst("Three"); // Three
        list.addFirst("Two"); // Two, Three
        list.addFirst("One"); // One, Two, Three
        list.addLast("Four"); // One, Two, Three, Four
        list.addLast("Five"); // One, Two, Three, Four, Five

        while (!list.isEmpty()) {
            System.out.println(list.removeFirst());
        }
    }
}
