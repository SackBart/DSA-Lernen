package org.main.algorithms.Dijkstra;

import org.main.graphs.WeightedAdjacencyMatrixGraph;

public class Dijkstra {
    public static void printShortestPaths(WeightedAdjacencyMatrixGraph graph, int start) {
        if (graph.getAmountOfNodes() == 0) {
            return;
        }

        int[] shortestPathValues = new int[graph.getAmountOfNodes()];
        PriorityQueue queue = new PriorityQueue();

        for (int i = 0; i < graph.getAmountOfNodes(); i++) {
            shortestPathValues[i] = Integer.MAX_VALUE;
            queue.add(new PriorityQueueCell(i, Integer.MAX_VALUE));
        }

        shortestPathValues[start] = 0;
        queue.set(start, 0);

        while (!queue.isEmpty()) {
            PriorityQueueCell u = queue.removeIndexWithLowestValue();
            Integer[] values = graph.getConnectionsOf(u.getIndex());

            for (int i = 0; i < values.length; i++) {
                if (values[i] != null && queue.contains(i)) {
                    if (shortestPathValues[u.getIndex()] + graph.getWeightOnEdge(u.getIndex(),i) < shortestPathValues[i]) {
                        shortestPathValues[i] = shortestPathValues[u.getIndex()] + graph.getWeightOnEdge(u.getIndex(), i);
                        queue.set(i,shortestPathValues[i]);
                    }
                }
            }
        }

        for (int i = 0; i < graph.getAmountOfNodes(); i++) {
            System.out.println("Node " + i + " has value " + shortestPathValues[i]);
        }
    }
}
