# A Star (*)  Algorithm 

<div align="center">
<img src="https://github.com/sergiobriito/astar-algorithm/assets/64617586/be7f073d-de77-4966-a98d-f4d7dd0c3d9f" alt="drawing" width="500"/>
</div>


The A* algorithm, often pronounced "A-star," is a popular pathfinding and graph traversal algorithm used to find the shortest path between two points in a graph. It is widely applied in various fields, including robotics, video games, and geographic information systems (GIS). A* is an informed search algorithm that combines elements of Dijkstra's algorithm and Greedy Best-First Search.
It works by maintaining two sets of nodes:

- **Open Set**: Nodes that need to be explored, sorted by their estimated cost from the start node.
- **Closed Set**: Nodes that have already been evaluated.

The A* algorithm uses two functions to evaluate nodes:

- `f(n)`: The total estimated cost of the cheapest path from the start node to the goal node through node `n`.
- `g(n)`: The cost of the path from the start node to node `n`.
- `h(n)`: The heuristic estimate of the cost from node `n` to the goal node.

The A* algorithm selects nodes from the open set with the lowest `f(n)` value (cost + heuristic) and expands them. It then checks if the goal node has been reached or if the path can be further improved by exploring the neighboring nodes.



