# Dijkstra's Algorithm - Java Implementation

## Overview
This project implements **Dijkstra's Algorithm** in Java to find the shortest path from a starting node to all other nodes in a graph. The adjacency list is represented using a `HashMap`, where each node is associated with a list of neighboring nodes and their respective edge weights. The algorithm utilizes a **min-heap (priority queue)** to efficiently determine the shortest paths.

## Features
- Implements **Dijkstra’s Algorithm** using a **priority queue** for efficiency.
- Uses a **HashMap-based adjacency list** to store graph edges.
- Outputs the shortest paths from a specified start node to all other nodes.
- Can be extended for **real-world applications**, such as **route optimization, network routing, or AI pathfinding**.

## How It Works
1. **Graph Representation**:
   - The graph is stored as an **adjacency list** using a `HashMap<String, List<String[]>>`, where each node maps to a list of its neighbors and edge weights.
   
2. **Priority Queue (Min-Heap)**:
   - A **priority queue (min-heap)** is used to always process the node with the current shortest known distance first.
   
3. **Algorithm Flow**:
   - Start from the given node and initialize a **min-heap** with `(0, startNode)` (distance, node).
   - Continuously extract the **node with the smallest distance** from the priority queue.
   - Update distances to neighboring nodes **if a shorter path is found**.
   - Push updated neighbors into the priority queue.
   - Continue until all nodes have been processed.

4. **Output**:
   - The algorithm returns a **map of shortest distances** from the start node to all reachable nodes.

## Example Usage
### Sample Graph Structure:
```java
DijkstraGraph graph = new DijkstraGraph();
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
```

### Running Dijkstra’s Algorithm:
```java
Map<String, Integer> shortestPaths = graph.dijkstra("A");
System.out.println("Shortest paths from A: " + shortestPaths);
```

### Expected Output:
```
Shortest paths from A: {A=0, B=2, D=7, E=8, F=9, C=17}
```

## Future Enhancements
- Add **bidirectional edges** automatically.
- Implement **real-time path updates** for dynamic graphs.
- Extend to **support multiple source nodes**.


