package org.main.graphs;

import java.util.ArrayList;

public class AdjacencyListGraph {
    private ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();

    public int addNode() {
        // Add new node
        adjacencyList.add(new ArrayList<>());
        return adjacencyList.size();
    }

    public boolean addEdge(int from, int to) {
        // Get amount of nodes
        int numNodes = adjacencyList.size();

        // If nodes are not inside the boundary (1 - size), then it's not possible to add an edge
        if (from > numNodes || to > numNodes || from < 1 || to < 1) {
            return false;
        }

        // Does edge already exist?
        for (int n : adjacencyList.get(from - 1)) {
            if (n == to) {
                return false;
            }
        }

        // Add the target node to the list of the origin node
        adjacencyList.get(from - 1).add(to);

        return true;
    }
}
