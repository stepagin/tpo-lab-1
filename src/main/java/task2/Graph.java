package task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private Map<Integer, List<Integer>> graph;

    public Graph() {
        this.graph = new HashMap<>();
    }

    public void addEdge(int u, int v) {
        graph.putIfAbsent(u, new ArrayList<>());
        graph.get(u).add(v);
    }

    private List<Integer> dfsUtil(int v, boolean[] visited, List<Integer> result) {
        visited[v] = true;
        result.add(v);

        List<Integer> neighbors = graph.get(v);
        if (neighbors != null) {
            for (int i : neighbors) {
                if (!visited[i]) {
                    dfsUtil(i, visited, result);
                }
            }
        }
        return result;
    }

    public List<Integer> dfs(int start) {
        if (graph.get(start) == null) {
            throw new IllegalArgumentException("The initial vertex is incorrect");
        }
        boolean[] visited = new boolean[graph.size()];
        List<Integer> result = new ArrayList<>();
        return dfsUtil(start, visited, result);
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        List<Integer> result = g.dfs(2);
    }
}

