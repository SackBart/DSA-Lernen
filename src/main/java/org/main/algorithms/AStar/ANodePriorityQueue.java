package org.main.algorithms.AStar;

import java.util.ArrayList;
import java.util.List;

public class ANodePriorityQueue {
    List<NodePropertyAStar> queue = new ArrayList<>();

    public void add(NodePropertyAStar property) {
        queue.add(property);
    }

    public NodePropertyAStar removeLowestGeneralCost() {
        if (queue.isEmpty()) {
            return null;
        }

        int lowestIndex = 0;

        for (int i = 1; i < queue.size(); i++) {
            if (queue.get(i).getSumCost() < queue.get(lowestIndex).getSumCost()) {
                lowestIndex = i;
            }
        }

        return queue.remove(lowestIndex);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

    public boolean contains(int index) {
        for (NodePropertyAStar property : queue) {
            if (property.getIndex() == index) {
                return true;
            }
        }
        return false;
    }

    public NodePropertyAStar getNodeWithIndex(int index) {
        for (NodePropertyAStar property : queue) {
            if (property.getIndex() == index) {
                return property;
            }
        }
        return null;
    }
}
