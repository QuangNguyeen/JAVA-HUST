package samsung.java.week2.subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Graph {
    private Map<Integer, List<Integer>> graph;

    public Graph() {
        this.graph = new HashMap<>();
    }

    public void addEdge(int u, int v) {
        graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
    }

    private List<Integer> findPathDLS(int v, int target, int depthLimit, List<Integer> path) {
        if (v == target) {
            path.add(v);
            return path;
        }
        if (depthLimit <= 0) {
            return null;
        }

        path.add(v);
        for (int neighbour : graph.getOrDefault(v, new ArrayList<>())) {
            List<Integer> newPath = new ArrayList<>(path);
            List<Integer> result = findPathDLS(neighbour, target, depthLimit - 1, newPath);
            if (result != null) {
                return result;
            }
        }
        return null;
    }

    public void DLS(int start, int target, int depthLimit) {
        List<Integer> path = findPathDLS(start, target, depthLimit, new ArrayList<>());
        if (path != null) {
            System.out.printf("Path from %d to %d with depth limit %d: %s%n", start, target, depthLimit, path);
        } else {
            System.out.printf("No path found from %d to %d with depth limit %d%n", start, target, depthLimit);
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph();

        g.addEdge(1, 2);
        g.addEdge(1, 5);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 7);
        g.addEdge(3, 5);
        g.addEdge(3, 6);
        g.addEdge(4, 8);
        g.addEdge(5, 7);
        g.addEdge(6, 9);
        g.addEdge(7, 10);
        g.addEdge(8, 10);
        g.addEdge(9, 10);

        g.DLS(1, 10, 3);
    }
}

