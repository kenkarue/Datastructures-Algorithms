package DSGraph;

import java.util.*;
import DSGraph.Graph.Node;

/**
 * Breadth search:
 *  Using Iterative approach
 */
public class BreadthTraversal {
    static Map<Graph.Node, List<Graph.Node>> adjList = new HashMap<>();
    static Map<String, Graph.Node> nodes = new HashMap<>();

    public static void main(String[] arg){
        // create Graph data
        Graph graph = new Graph();
        graph.addNode("Kenya");
        graph.addNode("Uganda");
        graph.addNode("Tanzania");
        graph.addNode("Sudan");
        graph.addNode("Somalia");
        graph.addEdges("Kenya","Uganda");
        graph.addEdges("Kenya","Tanzania");
        graph.addEdges("Kenya","Somalia");
        graph.addEdges("Uganda","Tanzania");
        graph.addEdges("Sudan","Kenya");
        graph.addEdges("Sudan","Uganda");
        graph.addEdges("Somalia","Sudan");
        adjList = graph.getAdjList();
        nodes = graph.getNodes();
        // depth search
        iterative("Sudan");
        // recursive
        //Graph.Node current = nodes.get("Kenya");
        //recursive(current, new HashSet<>());
    }

    private static void iterative(String startingPoint){
        Node start = nodes.get(startingPoint);
        if(start == null){
            return;
        }
        Set<Node> visited = new HashSet<>();
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()){
            Node current = queue.poll();
            if(visited.contains(current)){
                continue;
            }
            for(Node l: adjList.get(current)){
                if(!visited.contains(current)){
                    queue.add(l);
                }
            }
            System.out.print(" "+current.label);
            visited.add(current);
        }
    }
}
