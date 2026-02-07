package org.main.graphs;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * An edge list is a list of numbers that tell how many nodes, edges and how connected they are:
 *
 * a, b, x_1, y_1, x_2, y_2, x_3, y_3, ...
 *
 * a: Amount Nodes
 * b: Amount Edges
 *
 * x_i, y_i: An edge from node x_i to y_i
 *
 * With that it can make an efficient way to create a graph
 */
public class EdgeListGraph {
    // make an empty edge list [0, 0]
    private ArrayList<Integer> edgeList = new ArrayList<>(Arrays.asList(0,0));

    public int addNode() {
        int numNodes = edgeList.getFirst() + 1;
        edgeList.set(0, numNodes);
        return numNodes;
    }

    public boolean addEdge(int from, int to) {
        // If nodes are not inside the boundary (1 - size), then it's not possible to add an edge
        if (from > edgeList.getFirst() || to > edgeList.getFirst() || from < 1 || to < 1) {
            return false;
        }

        // Look if the edge already exists
        for (int i = 2; i < edgeList.size(); i += 2) { // start at x_1 and end at the end of the list
            /*
                compare x_i with from and y_i with y.
                If both are the same then the edge already exists
             */
            if (edgeList.get(i) == from && edgeList.get(i + 1) == to) {
                return false;
            }
        }

        // Add the edge information at the end of the list
        edgeList.add(from);
        edgeList.add(to);
        // Increase the edge amount number by one
        int numEdges = edgeList.get(1) + 1;
        edgeList.set(1, numEdges);
        return true;
    }
}
