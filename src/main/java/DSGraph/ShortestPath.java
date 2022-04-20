package DSGraph;

import SharedClasses.Edge;
import SharedClasses.Node;
import SharedClasses.Path;

import java.util.*;

import static DSGraph.Weighted.getAdjList;
import static DSGraph.Weighted.getNodes;

/**
 * Input:
 *   String: from
 *   String: to
 * Output:
 *   List: from node ---> to node
 */
public class ShortestPath {

    public static void main(String[] args){
        // inputs
        String start = "A";
        String end = "Ej";

        // create graph
        createGraph();
        Map<String, Node> nodes = getNodes();
        Map<Node, List<Edge>> adjList = getAdjList();

        // shortest path
        List<String> shortestPath = getShortestPath(start, end, nodes, adjList);
        System.out.println(shortestPath.toString());


    }

    private static List<String> getShortestPath(String start, String end, Map<String, Node> nodes, Map<Node, List<Edge>> adjList) {
        if(!nodes.containsKey(start)){
            throw new IllegalArgumentException("Invalid start parameter");
        }
        if(!nodes.containsKey(end)){
            throw new IllegalArgumentException("Invalid end parameter");
        }
        Set<Node> visited = new HashSet<>();
        Map<Node, Integer> distance = new HashMap<>();
        Map<Node, Node> previousNode = new HashMap<>();
        Node startNode = nodes.get(start);
        for(Node node: nodes.values()){
            distance.put(node, Integer.MAX_VALUE);
            previousNode.put(node, null);
        }
        distance.put(startNode, 0);
        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x.priority));
        queue.add(new NodeEntry(startNode, 0));
        while(!queue.isEmpty()){
            Node currentNode = queue.remove().node;
            for(Edge currentEdge: adjList.get(currentNode)){
                if(visited.contains(currentEdge.to)){
                    continue;
                }
                int totalDistance = distance.get(currentNode) + currentEdge.weight;
                if(totalDistance < distance.get(currentEdge.to)){
                    distance.put(currentEdge.to, totalDistance);
                    previousNode.put(currentEdge.to, currentNode);
                    queue.add(new NodeEntry(currentEdge.to, totalDistance));
                }
            }
        }
        // we add to the list
        Node endNode = previousNode.get(nodes.get(end));
        Stack<String> stackOfPath = new Stack<>();
        stackOfPath.push(nodes.get(end).label);
        while(endNode != null){
            stackOfPath.push(endNode.label);
            endNode = previousNode.get(endNode);
        }
        Path shortPath = new Path();
        while(!stackOfPath.isEmpty()){
            shortPath.add(stackOfPath.pop());
        }
        return shortPath.getList();
    }

    private static void createGraph() {
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
    }

    static class NodeEntry{
        Node node;
        int priority;

        NodeEntry(Node node, int priority){
            this.node = node;
            this.priority = priority;
        }
    }
}
