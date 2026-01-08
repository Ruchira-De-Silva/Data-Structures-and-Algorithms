package data_structures.weighted_graphs.adjecencyList;

public class Edge {
    private final Vertex vertex;
    private final int weight;

    public Edge(Vertex vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    public Vertex getVertex() {
        return vertex;
    }

    public int getWeight() {
        return weight;
    }

}
