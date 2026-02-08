package org.main.examples.algorithms;

import org.main.algorithms.AStar.AStar;
import org.main.algorithms.AStar.CustomWeightedAdjacencyMatrixGraph;
import org.main.algorithms.AStar.NodePropertyAStar;

public class TestAStar {
    public static void main(String[] args) {
        CustomWeightedAdjacencyMatrixGraph graph = new CustomWeightedAdjacencyMatrixGraph();

        graph.addNode(new NodePropertyAStar(0, 0, 0));
        graph.addNode(new NodePropertyAStar(1, 4, 2));
        graph.addNode(new NodePropertyAStar(2, 4, 0));
        graph.addNode(new NodePropertyAStar(3, 5, 0));
        graph.addNode(new NodePropertyAStar(4, 4, 2));

        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 5);

        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 4, 1);

        graph.addEdge(2, 1, 3);
        graph.addEdge(2, 3, 2);

        graph.addEdge(3, 4, 6);

        graph.addEdge(4, 3, 5);

        AStar.printShortestPath(graph, 0, 4);
    }
}
