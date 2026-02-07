package org.main.graphs;

public class WeightedAdjacencyMatrixGraph {
    private Integer[][] adjacencyMatrix = null;

    public int addNode() {
        // Get the old amount of nodes
        int numNodes = (adjacencyMatrix == null) ? 0 : adjacencyMatrix.length;

        // New matrix with one more column and row
        Integer[][] newAdjacencyMatrix = new Integer[numNodes + 1][numNodes + 1];

        // Paste the old matrix to the new matrix
        for (int i = 0; i < numNodes; i++) {
            for (int j = 0; j < numNodes; j++) {
                if ((adjacencyMatrix != null) && (adjacencyMatrix[i][j] != null)) {
                    newAdjacencyMatrix[i][j] = adjacencyMatrix[i][j]; // Else put the saved value from the old matrix
                }
            }
        }
        adjacencyMatrix = newAdjacencyMatrix;

        return numNodes + 1;
    }

    public boolean addEdge(int from, int to, Integer weight) {
        // Determine the count of the nodes
        int numNodes = (adjacencyMatrix == null) ? 0 : adjacencyMatrix.length;

        // Does the node exist?
        if (from > numNodes - 1 || to > numNodes - 1 || from < 0 || to < 0) {
            return false;
        }

        // Does the edge already exist?
        if (adjacencyMatrix[from][to] != null) { // -1 because index starts at 0
            return false;
        }

        // Insert edge
        int newWeight = weight == null ? 0 : weight;
        adjacencyMatrix[from][to] = newWeight;
        return true;
    }

    public Integer[] getConnectionsOf(int nodeNumber) {
        int numNodes = (adjacencyMatrix == null) ? 0 : adjacencyMatrix.length;

        if (nodeNumber < 0 || nodeNumber > numNodes - 1) {
            return null;
        }
        return adjacencyMatrix[nodeNumber];
    }

    public Integer getWeightOnEdge(int from, int to) {
        int numNodes = (adjacencyMatrix == null) ? 0 : adjacencyMatrix.length;

        if (from > numNodes - 1 || to > numNodes - 1 || from < 0 || to < 0) {
            return null;
        }

        return adjacencyMatrix[from][to];
    }

    public int getAmountOfNodes() {
        return adjacencyMatrix.length;
    }

    public boolean nodeExists(int node) {
        int numNodes = (adjacencyMatrix == null) ? 0 : adjacencyMatrix.length;
        return node <= numNodes && node >= 1;
    }

    public void addNodes(int amount) {
        for (int i = 0; i < amount; i++) {
            addNode();
        }
    }

    public void print() {
        System.out.print("  ");
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                if  (adjacencyMatrix[i][j] != null) {
                    System.out.print(adjacencyMatrix[i][j] + " ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}
