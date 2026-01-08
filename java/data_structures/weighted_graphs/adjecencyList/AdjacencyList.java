package data_structures.weighted_graphs.adjecencyList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class AdjacencyList {
    Set<Vertex> adjList;

    public AdjacencyList() {
        this.adjList = new HashSet<>();
    }

    private Vertex findVertex(int key) {
        for (Vertex vertex : adjList) {
            if (vertex.getKey() == key) {
                return vertex;
            }
        }
        return null;
    }

    public void addVertex(int key) {
        if (!adjList.add(new Vertex(key)))
            throw new IllegalArgumentException("Vertex " + key + " already exists in the graph.");
    }

    public void addEdge(int sourceKey, int neighborKey, int weight) {
        Vertex source = findVertex(sourceKey);
        Vertex neighbor = findVertex(neighborKey);

        if (source == null || neighbor == null) {
            throw new IllegalArgumentException("Vertex not found.");
        }

        source.addEdge(neighbor, weight);
    }

    public Set<Vertex> getAdjList() {
        return adjList;
    }

    // public ArrayList<Integer> dfs(int sourceKey, int targetKey) {
    // if (findVertex(sourceKey) == null || findVertex(targetKey) == null) {
    // throw new IllegalArgumentException("Vertex not found.");
    // }

    // ArrayList<Integer> path = new ArrayList<>();

    // return path;
    // }

    public ArrayList<Integer> dijkstra(int sourceKey, int targetKey) {
        if (adjList.isEmpty())
            throw new IllegalStateException("Graph is empty");

        Vertex source = findVertex(sourceKey);
        Vertex target = findVertex(targetKey);

        if (source == null || target == null)
            throw new IllegalArgumentException("Vertex not found.");

        for (Vertex vertex : adjList) {
            vertex.setDistance(Integer.MAX_VALUE);
        }
        source.setDistance(0);

        HashMap<Vertex, Vertex> parentMap = new HashMap<>();
        Set<Vertex> inQueue = new HashSet<>();
        PriorityQueue<Vertex> queue = new PriorityQueue<>();

        queue.offer(source);
        inQueue.add(source);
        parentMap.put(source, null);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            inQueue.remove(current);

            if (current == target)
                break;

            for (Edge edge : current.getEdges()) {
                Vertex neighbor = edge.getVertex();
                int newDistance = current.getDistance() + edge.getWeight();

                if (newDistance < neighbor.getDistance()) {
                    neighbor.setDistance(newDistance);
                    parentMap.put(neighbor, current);

                    if (inQueue.contains(neighbor)) {
                        queue.remove(neighbor);
                    }
                }
                queue.offer(neighbor);
                inQueue.add(neighbor);
            }
        }

        return getShortestPath(parentMap, target);
    }

    private ArrayList<Integer> getShortestPath(HashMap<Vertex, Vertex> parentMap, Vertex current) {
        ArrayList<Integer> path = new ArrayList<>();

        while (current != null) {
            path.add(0, current.getKey());
            current = parentMap.get(current);
        }

        return path;
    }

}
