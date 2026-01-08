package data_structures.graphs.adjecencyList;

import java.util.HashSet;
import java.util.Set;

public class Vertex {
    private final int key;
    private final Set<Vertex> adjVertex; // avoids duplicates

    public Vertex(int key) {
        this.key = key;
        this.adjVertex = new HashSet<>();
    }

    public int getKey() {
        return key;
    }

    public Set<Vertex> getAdjacentVertices() {
        return adjVertex;
    }

    public void addAdjacentVertices(Vertex vertex) {
        if (vertex == null) {
            throw new IllegalArgumentException("Vertex cannot be null");
        }

        if (vertex == this) {
            throw new IllegalArgumentException("Vertex cannot Self-loop");
        }

        if (!adjVertex.add(vertex)) {
            throw new IllegalArgumentException("Duplicate Edge " + vertex.getKey() + " found.");
        }
    }
}
