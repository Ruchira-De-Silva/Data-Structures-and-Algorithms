package data_structures.weighted_graphs.adjecencyList;

import java.util.ArrayList;

public class Vertex implements Comparable<Vertex> {
    private final int key;
    private ArrayList<Edge> edges;
    private int distance = Integer.MAX_VALUE;

    public Vertex(int key) {
        this.key = key;
        this.edges = new ArrayList<>();
    }

    public int getKey() {
        return key;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public void addEdge(Vertex vertex, int weight) {
        for (Edge edge : edges) {
            if (edge.getVertex() == vertex) {
                throw new IllegalArgumentException("Edge exists in the adjacency list.");
            }
        }
        edges.add(new Edge(vertex, weight));
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public int compareTo(Vertex adjVertex) {
        return Integer.compare(this.distance, adjVertex.distance);
    }
}
