package org.main.examples.algorithms;

import org.main.algorithms.Dijkstra.Dijkstra;
import org.main.graphs.WeightedAdjacencyMatrixGraph;

public class TestDijkstra {
    public static void main(String[] args) {
        WeightedAdjacencyMatrixGraph graph = new WeightedAdjacencyMatrixGraph();

        graph.addNodes(5);

        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 3, 5);

        graph.addEdge(1, 3, 2);
        graph.addEdge(1, 2, 1);

        graph.addEdge(2, 4, 5);

        graph.addEdge(3, 1, 3);
        graph.addEdge(3, 4, 2);

        graph.addEdge(4, 2, 6);
        graph.addEdge(4, 0, 7);

        Dijkstra.printShortestPaths(graph, 4);
    }
}
