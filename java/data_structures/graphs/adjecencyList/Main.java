package data_structures.graphs.adjecencyList;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // 1. Create a sample graph
        AdjacencyList graph = new AdjacencyList();

        // Add vertices
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);

        // Add edges
        graph.addEdge(1, 2); // 1 → 2
        graph.addEdge(1, 4); // 1 → 3
        graph.addEdge(2, 3); // 2 → 3
        graph.addEdge(2, 5); // 2 → 5
        graph.addEdge(5, 4); // 5 → 4
        // graph.addEdge(5, 3);

        // 2. Run BFS from vertex 1 to 4
        System.out.println("Raw BFS traversal data from 1 to 3:");
        ArrayList<Integer> bfsResult = graph.simplebfs(1, 3);

        // 3. Print all parent-child pairs exactly as returned
        System.out.println("\nPath:");
        System.out.println(bfsResult.size());
        for (int parent : bfsResult) {
            System.out.print(parent + " --> ");
        }

        System.out.println("\n");
        System.out.println("Parent --> Child");

        HashMap<Vertex, Vertex> bfsResult2 = graph.bfs(1, 3);
        for (Vertex entry : bfsResult2.keySet()) {
            Vertex parent = (bfsResult2.get(entry) == null) ? null : bfsResult2.get(entry);

            if (parent == null) {
                System.out.println("null -> " + entry.getKey());
            } else {
                System.out.println(bfsResult2.get(entry).getKey() + " -> " + entry.getKey());
            }
        }
    }
}