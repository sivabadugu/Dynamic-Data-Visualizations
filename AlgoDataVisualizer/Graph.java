import java.util.*;

class Graph {
    // Adjacency list representation of the graph
    private final Map<Integer, List<Integer>> adjList = new HashMap<>();

    // Method to add an edge between two vertices v and w
    public void addEdge(int v, int w) {
        // Add w to the adjacency list of v and vice versa for an undirected graph
        adjList.computeIfAbsent(v, k -> new ArrayList<>()).add(w);
        adjList.computeIfAbsent(w, k -> new ArrayList<>()).add(v);
    }

    // Method to perform Depth-First Search (DFS) starting from a given vertex
    public List<Integer> dfs(int start) {
        Set<Integer> visited = new HashSet<>(); // To keep track of visited vertices
        List<Integer> result = new ArrayList<>(); // To store the order of visited vertices
        dfsUtil(start, visited, result); // Start the recursive DFS
        return result; // Return the result list
    }

    // Recursive helper method for DFS
    private void dfsUtil(int v, Set<Integer> visited, List<Integer> result) {
        visited.add(v); // Mark the current vertex as visited
        result.add(v); // Add the current vertex to the result list

        // Explore each neighbor of the current vertex
        for (int neighbor : adjList.getOrDefault(v, Collections.emptyList())) {
            // If the neighbor has not been visited, recursively visit it
            if (visited.add(neighbor)) { // add returns false if already present
                dfsUtil(neighbor, visited, result);
            }
        }
    }

    // Method to perform Breadth-First Search (BFS) starting from a given vertex
    public List<Integer> bfs(int start) {
        Set<Integer> visited = new HashSet<>(); // To keep track of visited vertices
        List<Integer> result = new ArrayList<>(); // To store the order of visited vertices
        Queue<Integer> queue = new LinkedList<>(); // Queue for BFS
        queue.add(start); // Enqueue the starting vertex
        visited.add(start); // Mark it as visited

        // Continue until there are no more vertices to process
        while (!queue.isEmpty()) {
            int v = queue.poll(); // Dequeue a vertex
            result.add(v); // Add it to the result list

            // Explore each neighbor of the dequeued vertex
            for (int neighbor : adjList.getOrDefault(v, Collections.emptyList())) {
                // If the neighbor has not been visited, enqueue it
                if (visited.add(neighbor)) {
                    queue.add(neighbor);
                }
            }
        }
        return result; // Return the result list
    }

    // Method to check if the graph is connected
    public boolean isConnected() {
        // An empty graph is considered connected
        if (adjList.isEmpty()) return true;

        Set<Integer> visited = new HashSet<>(); // To track visited vertices
        // Start DFS from an arbitrary vertex (the first key in the adjacency list)
        dfsUtil(adjList.keySet().iterator().next(), visited, new ArrayList<>());
        
        // Check if all vertices were visited
        return visited.size() == adjList.size();
    }
}
