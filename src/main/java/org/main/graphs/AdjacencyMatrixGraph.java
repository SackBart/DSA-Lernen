package org.main.graphs;

public class AdjacencyMatrixGraph {
    private boolean[][] adjacencyMatrix = null;

    public int addNode() {
        // Get the old amount of nodes
        int numNodes = (adjacencyMatrix == null) ? 0 : adjacencyMatrix.length;

        // New matrix with one more column and row
        boolean[][] newAdjacencyMatrix = new boolean[numNodes + 1][numNodes + 1];

        // Paste the old matrix to the new matrix
        for (int i = 0; i <= numNodes; i++) {
            for (int j = 0; j <= numNodes; j++) {
                if ((i == numNodes) || (j == numNodes)) { // Is the rows or the columns within the old boundary?
                    newAdjacencyMatrix[i][j] = false; // Add the edge if it doesn't exist
                } else {
                    newAdjacencyMatrix[i][j] = adjacencyMatrix[i][j]; // Else put the saved value from the old matrix
                }
            }
        }
        adjacencyMatrix = newAdjacencyMatrix;

        return numNodes + 1;
    }

    public boolean addEdge(int from, int to) {
        // Determine the count of the nodes
        int numNodes = (adjacencyMatrix == null) ? 0 : adjacencyMatrix.length;

        // Does the node exist?
        if (from > numNodes || to > numNodes || from < 1 || to < 1) {
            return false;
        }

        // Does the edge already exist?
        if (adjacencyMatrix[from - 1][to - 1]) { // -1 because index starts at 0
            return false;
        }

        // Insert edge
        adjacencyMatrix[from - 1][to - 1] = true;
        return true;
    }
}
