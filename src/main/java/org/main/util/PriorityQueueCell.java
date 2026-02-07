package org.main.util;

public class PriorityQueueCell {
    int index;
    int value;

    public PriorityQueueCell(int index, int value) {
        this.index = index;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public void print() {
        System.out.println("Value: " + value);
        System.out.println("Index: " + index);
    }
}
