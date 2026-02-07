package org.main.graphs.nodes;

import java.util.Set;
import java.util.TreeSet;

public class DynamicGraphNode implements Comparable<DynamicGraphNode>{
    int key;
    Set<DynamicGraphNode> outgoingEdges = new TreeSet<>();

    public DynamicGraphNode(int key){
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public Set<DynamicGraphNode> getOutgoingEdges() {
        return outgoingEdges;
    }

    @Override
    public int compareTo(DynamicGraphNode o) {
        if (this.key < o.key) {
            return -1;
        } else if (this.key > o.key) {
            return 1;
        } else {
            return 0;
        }
    }
}
