package org.main.algorithms.AStar;

import java.util.ArrayList;
import java.util.List;

public class AStar {
    private static void expand(
            CustomWeightedAdjacencyMatrixGraph graph,
            NodePropertyAStar nodeFrom,
            ANodePriorityQueue OPEN,
            List<NodePropertyAStar> CLOSED,
            NodePropertyAStar finish
    ) {
        Integer[] values = graph.getConnectionsOf(nodeFrom.getIndex());

        for (int i = 0; i < values.length; i++) {
            NodePropertyAStar nodeTo = graph.getNodeProperty(i);
            if (values[i] != null && !CLOSED.contains(nodeTo)) {
                double tg = nodeFrom.getCostFromStart() + graph.getWeightOnEdge(nodeFrom.getIndex(), i);

                if (OPEN.contains(nodeTo.getIndex()) && tg >= nodeTo.getCostFromStart()) {
                    continue;
                }

                nodeTo.setPred(nodeFrom);
                nodeTo.setCostFromStart(tg);
                nodeTo.setSumCost(tg + nodeTo.getDistanceBetween(finish));
                if (!OPEN.contains(nodeTo.getIndex())) {
                    OPEN.add(nodeTo);
                }
            }
        }
    }

    public static void printShortestPath(CustomWeightedAdjacencyMatrixGraph graph, int from, int to) {
        // Assuming all nodes have been set properly
        NodePropertyAStar finish = graph.getNodeProperty(to);

        NodePropertyAStar start = graph.getNodeProperty(from);

        // g(start) := 0, f(start) := h(start)
        start.setCostFromStart(0);
        start.setSumCost(start.getDistanceBetween(finish));

        ANodePriorityQueue OPEN = new ANodePriorityQueue();
        List<NodePropertyAStar> CLOSED = new ArrayList<>();

        OPEN.add(start);

        while (!OPEN.isEmpty()) {
            NodePropertyAStar n = OPEN.removeLowestGeneralCost();

            if (finish == n) {
                System.out.println("Found Path: ");
                List<NodePropertyAStar> path = new ArrayList<>();
                NodePropertyAStar currentNode = n;

                while (currentNode != null) {
                    path.add(currentNode);
                    currentNode = currentNode.getPred();
                }

                for (int i = path.size() - 1; i >= 0; i--) {
                    System.out.print(path.get(i).getIndex());
                    if (i != 0) {
                        System.out.print(" -> ");
                    }
                }
                System.out.println();
            }

            expand(graph, n, OPEN, CLOSED, finish);
            CLOSED.add(n);
        }
    }
}
