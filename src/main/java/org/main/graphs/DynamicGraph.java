package org.main.graphs;

import org.main.graphs.nodes.DynamicGraphNode;

import java.util.*;

/**
 * A shit way to implement graphs nice
 */
public class DynamicGraph<K extends Comparable<K>> {
    private Set<DynamicGraphNode> entryPoints = new TreeSet<>();
    private int maxKey = 0;

    public int addNode() {
        maxKey++;
        entryPoints.add(new DynamicGraphNode(maxKey));
        return maxKey;
    }



    public DynamicGraphNode findNode(int k) {
        Deque<DynamicGraphNode> queue = new ArrayDeque<>(entryPoints);
        Set<DynamicGraphNode> found = new TreeSet<>(entryPoints);

        while (!queue.isEmpty()) { // while the queue is not empty
            DynamicGraphNode node = queue.poll(); // get the "oldest" node in the queue and remove it from the queue
            if (node.getKey() == k) { // if the key of the node is equal to the given key then return the node
                return node;
            }
            for (DynamicGraphNode destNode : node.getOutgoingEdges()) { // Get all the nodes connected to the node
                if (!found.contains(destNode)) { // If the node is not already visited
                    queue.add(destNode); // add the node to the queue
                    found.add(destNode); // add it to the found set
                }
            }
        }
        return null;
    }

    public boolean addEdge(int orig, int dest) {
        DynamicGraphNode origNode = findNode(orig); // get both nodes
        DynamicGraphNode destNode = findNode(dest);

        if (origNode == null || destNode == null) { // if any is nonexistent, dont add the edge
            return false;
        }

        origNode.getOutgoingEdges().add(destNode); // add the dest node on the list inside the orign node

        entryPoints.remove(destNode);

        if (findNode(orig) == null) {
            entryPoints.add(origNode);
        }

        return true;
    }
}
