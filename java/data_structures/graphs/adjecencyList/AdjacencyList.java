
package data_structures.graphs.adjecencyList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
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
        if (findVertex(key) != null) {
            throw new IllegalArgumentException("Vertex of key " + key + " already in adjacency list");
        }
        adjList.add(new Vertex(key));
    }

    public void addEdge(int sourceKey, int neighborKey) {
        Vertex source = findVertex(sourceKey);
        Vertex neighbor = findVertex(neighborKey);

        if (source == null || neighbor == null) {
            throw new IllegalArgumentException("Vertex not found.");
        }

        source.addAdjacentVertices(neighbor);
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

    public HashMap<Vertex, Vertex> bfs(int sourceKey, int targetKey) {
        Vertex source = findVertex(sourceKey);
        Vertex target = findVertex(targetKey);

        if (source == null || target == null)
            throw new IllegalArgumentException("Vertex not found.");

        HashMap<Vertex, Vertex> parentMap = new HashMap<>(); // child -> parent
        Set<Vertex> visited = new HashSet<>();
        Queue<Vertex> queue = new LinkedList<>();

        queue.offer(source); // sets null of the adding fails
        parentMap.put(source, null);
        visited.add(source);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();

            if (current.equals(target)) {
                System.out.println("From is equal flag");
                return parentMap;
            }

            for (Vertex adjVertex : current.getAdjacentVertices()) {
                if (!visited.contains(adjVertex)) {
                    visited.add(adjVertex);
                    parentMap.put(adjVertex, current);
                    queue.offer(adjVertex);
                }
            }
        }
        return new HashMap<>();
    }

    public HashMap<Vertex, Vertex> bfs(int sourceKey) {
        Vertex source = findVertex(sourceKey);

        if (source == null) {
            throw new IllegalArgumentException("Vertex not found.");
        }

        HashMap<Vertex, Vertex> parentMap = new HashMap<>(); // child -> parent
        Set<Vertex> visited = new HashSet<>();
        Queue<Vertex> queue = new LinkedList<>();

        queue.offer(source); // sets null of the adding fails
        parentMap.put(source, null);
        visited.add(source);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();

            for (Vertex adjVertex : current.getAdjacentVertices()) {
                if (!visited.contains(adjVertex)) {
                    visited.add(adjVertex);
                    parentMap.put(adjVertex, current);
                    queue.offer(adjVertex);
                }
            }
        }
        return parentMap;
    }

    /*
     * Following is the implementation of bfs using only ArrayLists and Queues
     */

    /**
     * @param sourceKey
     * @param targetKey
     * @return
     * 
     *         Sample graph :-
     *         1 → 2 → 3
     *         ↓ ↓
     *         4 ← 5
     * 
     *         Parent before formatting:-
     *         Parent --> Child (Stored as Child, Parent)
     *         1 -> 2
     *         1 -> 4
     *         2 -> 3
     *         2 -> 5
     *         null -> 1
     * 
     *         Limitations - Only the path found first is returned other paths are
     *         discarded
     */
    public ArrayList<Integer> simplebfs(int sourceKey, int targetKey) {
        Vertex source = findVertex(sourceKey);
        Vertex target = findVertex(targetKey);
        int count = 1;

        if (source == null || target == null)
            throw new IllegalArgumentException("Vertex not found.");

        ArrayList<Vertex[]> parentList = new ArrayList<>();
        Queue<Vertex> queue = new LinkedList<>();
        ArrayList<Vertex> visited = new ArrayList<>();

        parentList.add(new Vertex[] { null, source });
        System.out.println(count + " add: \nParent - " + null + "\tChild - " + source.getKey());
        count++;
        queue.offer(source);
        visited.add(source);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();

            if (current == target)
                return formatPath(parentList, target);

            for (Vertex adjVertex : current.getAdjacentVertices()) {
                if (!visited.contains(adjVertex)) {
                    parentList.add(0, new Vertex[] { current, adjVertex });
                    System.out.println(
                            count + " add: \nParent - " + current.getKey() + "\tChild - " + adjVertex.getKey());
                    count++;
                    queue.offer(adjVertex);
                    visited.add(adjVertex);
                }
            }
        }
        return formatPath(parentList, target);
    }

    public ArrayList<Integer> formatPath(ArrayList<Vertex[]> parentList, Vertex target) {
        ArrayList<Integer> path = new ArrayList<>();

        Vertex current = target;

        while (current != null) {
            path.add(current.getKey());

            boolean hasParent = false;
            for (Vertex[] entry : parentList) {
                if (entry[1] == current) {
                    System.out.println(entry[1].getKey());
                    if (entry[0] == null)
                        return path;

                    current = entry[0];
                    hasParent = true;
                    System.out.println("Size " + path.size());
                    break;
                }
            }
            if (!hasParent)
                break;
        }
        return path;
    }

    // public ArrayList<Vertex[]> filterShortest(ArrayList<Vertex[]> parentList,
    // Vertex target) {
    // if parentList
    // }
}
