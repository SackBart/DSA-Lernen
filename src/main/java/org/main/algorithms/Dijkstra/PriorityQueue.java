package org.main.algorithms.Dijkstra;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueue {
    List<PriorityQueueCell> queue = new ArrayList<>();


    public PriorityQueue() {}

    public void add(PriorityQueueCell cell) {
        queue.add(cell);
    }

    public PriorityQueueCell removeIndexWithLowestValue() {
        if (queue.isEmpty()) {
            return null;
        }

        int lowestIndex = 0;

        for (int i = 1; i < queue.size(); i++) {
            if (queue.get(i).getValue() < queue.get(lowestIndex).getValue()) {
                lowestIndex = i;
            }
        }
        PriorityQueueCell cell = queue.get(lowestIndex);
        queue.remove(lowestIndex);
        return cell;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
    public int size() {
        return queue.size();
    }
    public boolean contains(int index) {
        for (PriorityQueueCell cell : queue) {
            if (cell.getIndex() == index) {
                return true;
            }
        }
        return false;
    }
    public void set(int index, int value) {
        for (PriorityQueueCell cell : queue) {
            if (cell.getIndex() == index) {
                cell.setValue(value);
            }
        }
    }
}
