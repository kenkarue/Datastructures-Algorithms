package DSGraph;

import DSGraph.Graph.Node;
import netscape.security.UserTarget;

import java.util.*;

/**
 * Depth search:
 *  Using both Iterative and Recursive approach
 */
public class DepthTraversal {

    static Map<Node, List<Node>> adjList = new HashMap<>();
    static Map<String, Node> nodes = new HashMap<>();

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
        iterative("Kenya");
        // recursive
        Node current = nodes.get("Kenya");
        recursive(current, new HashSet<>());
    }

    private static void iterative(String startPoint){
        Node start = nodes.get(startPoint);
        if(start == null){
            return;
        }
        Set<String> visited = new HashSet<>();
        Stack<Node> s = new Stack<>();
        s.push(start);
        while(!s.isEmpty()){
            Node current = s.pop();
            if(visited.contains(current.label)){
                continue;
            }
            List<Node> l = adjList.get(current);
            for(Node i: l){
                if(!visited.contains(i.label))
                    s.push(i);
            }
            System.out.print(" "+current.label);
            visited.add(current.label);
        }
    }

    private static void recursive(Node current, Set<Node> visited){
        if(current == null){
            return;
        }
        System.out.print(" "+current.label);
        visited.add(current);
        for(Node temp: adjList.get(current)){
            if(!visited.contains(temp)){
                recursive(temp, visited);
            }
        }
    }
}
