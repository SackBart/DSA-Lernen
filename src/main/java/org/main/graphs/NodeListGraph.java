package org.main.graphs;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A node list is a list of numbers that tell how many nodes, edges and how connected they are:
 *
 * a, b, n_1, n_1_1, n_1_2, n_2, n_2_1, n_2_2, ...
 *
 * a: Amount nodes
 * b: Amount edges
 *
 * n_i: Node i has 2 Edges
 * n_i_x: Node i is connected to n_i_x
 */
public class NodeListGraph {
    private ArrayList<Integer> nodeList = new ArrayList<>(Arrays.asList(0,0));

    public int addNode() {
        // Add node at the end of the list
        nodeList.add(0);

        // Increment the counter of the nodes
        int numNodes = nodeList.get(0) + 1;
        nodeList.set(0, numNodes);
        return numNodes;
    }

    public boolean addEdge(int from, int to) {
        // If nodes are not inside the boundary (1 - size), then it's not possible to add an edge
        if (from > nodeList.getFirst() || to > nodeList.getFirst() || from < 1 || to < 1) {
            return false;
        }

        // Search the starting node
        int pos = 2;
        for (int i = 1; i < from; i++) {
            pos += 1 + nodeList.get(pos); // go to the next node
        }

        // Does the Edge already exist?
        int numSuccessors = nodeList.get(pos);
        for (int i = 1; i <= numSuccessors; i++) {
            if (nodeList.get(pos + 1) == to) {
                return false;
            }
        }

        // Increase the amount of edges
        numSuccessors++;
        nodeList.set(pos, numSuccessors);

        // Add the target node on the edge list
        // It will move the rest of the stuff to the right
        nodeList.add(pos + numSuccessors, to);

        // Increment global edge counter
        int numEdges = nodeList.get(1) + 1;
        nodeList.set(1, numEdges);
        return true;
    }
}
