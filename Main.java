import java.util.*;

class DijkstraGraph {
    private Map<String, List<String[]>> adjacencyList;

    public DijkstraGraph() {
        // Create Hashmap to create graph
        adjacencyList = new HashMap<>();
    }

    public void addEdge(String src, String dest, int weight) {

        // Add src node if not present
        adjacencyList.putIfAbsent(src, new ArrayList<>());
        // If it is, add the node and its weight
        adjacencyList.get(src).add(new String[]{dest, String.valueOf(weight)});
    }

    public Map<String, Integer> dijkstra(String start) {

        // Create hashmap that stores all distances
        Map<String, Integer> shortest = new HashMap<>(); 

        // Create minheap
        PriorityQueue<String[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> Integer.parseInt(a[0])));
        
        // Add src node to minHeap.
        minHeap.offer(new String[]{"0", start}); // (weight, node)
        
        while (!minHeap.isEmpty()) {
            // Create pop the min head of the minheap.
            String[] current = minHeap.poll();
            int weight = Integer.parseInt(current[0]);
            String node = current[1];
            
            // skip if node is already in the shortest hashmap
            if (shortest.containsKey(node)) {
                continue;
            }
            //else put it
            shortest.put(node, weight);
            
            // Search through each neighbhor
            for (String[] neighbor : adjacencyList.getOrDefault(node, new ArrayList<>())) {
                String neighborNode = neighbor[0];
                int edgeWeight = Integer.parseInt(neighbor[1]);
                
                // Check if the neighbhor has not been visited
                if (!shortest.containsKey(neighborNode)) {
                    // Add to the minHeap
                    minHeap.offer(new String[]{String.valueOf(weight + edgeWeight), neighborNode});
                }
            }
        }
        return shortest;
    }

    public static void main(String[] args) {
        DijkstraGraph graph = new DijkstraGraph();
        
        // Creating adjacency list with array instead of pairs
        graph.addEdge("A", "B", 2);
        graph.addEdge("A", "D", 8);
        graph.addEdge("B", "A", 2);
        graph.addEdge("B", "D", 5);
        graph.addEdge("B", "E", 6);
        graph.addEdge("C", "E", 9);
        graph.addEdge("C", "F", 3);
        graph.addEdge("D", "A", 8);
        graph.addEdge("D", "B", 5);
        graph.addEdge("D", "E", 3);
        graph.addEdge("D", "F", 2);
        graph.addEdge("E", "B", 6);
        graph.addEdge("E", "D", 3);
        graph.addEdge("E", "C", 9);
        graph.addEdge("E", "F", 1);
        graph.addEdge("F", "D", 2);
        graph.addEdge("F", "E", 1);
        graph.addEdge("F", "C", 3);
        
        Map<String, Integer> shortestPaths = graph.dijkstra("A");
        
        System.out.println("Shortest paths from A: " + shortestPaths);
    }
}
