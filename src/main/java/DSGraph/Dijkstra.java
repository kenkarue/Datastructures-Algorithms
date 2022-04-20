package DSGraph;

import SharedClasses.Edge;
import SharedClasses.Node;
import java.util.*;
import static DSGraph.Weighted.getAdjList;
import static DSGraph.Weighted.getNodes;

public class Dijkstra {

    static Map<Node, Integer> distance = new HashMap<>();
    static Map<Node, Node> previousNodes = new HashMap<>();

    public static void main(String[] args){
        Weighted weighedGraph = new Weighted();
        // add nodes
        weighedGraph.addNode("A");
        weighedGraph.addNode("B");
        weighedGraph.addNode("C");
        weighedGraph.addNode("D");
        weighedGraph.addNode("E");

        // add vertices
        weighedGraph.addEdge("A", "B", 1);
        weighedGraph.addEdge("A", "C", 1);
        weighedGraph.addEdge("A", "D", 3);
        weighedGraph.addEdge("C", "D", 1);
        weighedGraph.addEdge("B", "E", 7);
        weighedGraph.addEdge("D", "E", 3);

        System.out.println(getShortestPath("A", "E"));
    }

    private static int getShortestPath(String from, String to){
        Map<String, Node> nodes = getNodes();
        Map<Node, List<Edge>> adjList = getAdjList();
        if(!nodes.containsKey(from) || !nodes.containsKey(to)){
            return -1;
        }
        Node start = nodes.get(from);
        Node end = nodes.get(to);
        NodeEntry entry = new NodeEntry(start, 0);
        Set<Node> visited = new HashSet<>();
        autoFillDistance(adjList);
        distance.put(start, 0);

        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x.priority));
        queue.add(entry);
        while(!queue.isEmpty()){
            Node current = queue.remove().node;
            visited.add(current);
            List<Edge> adjacent = adjList.get(current);
            for(Edge edges: adjacent) {
                Node adjNode = edges.to;
                int dist = edges.weight;
                int totalDistance = dist + distance.get(current);
                if(totalDistance < distance.get(adjNode)){
                    distance.put(adjNode, totalDistance);
                    previousNodes.put(adjNode, current);
                }
                if(!visited.contains(adjNode)){
                    queue.add(new NodeEntry(adjNode, totalDistance));
                }
            }
        }
        return distance.get(end);
    }


    private static void autoFillDistance(Map<Node, List<Edge>> adjList){
        for(Node key: adjList.keySet()){
            distance.put(key, Integer.MAX_VALUE);
            previousNodes.put(key, null);
        }
    }


}

class NodeEntry{
    Node node;
    int priority;

    public NodeEntry(Node node, int priority){
        this.node = node;
        this.priority = priority;
    }
}
