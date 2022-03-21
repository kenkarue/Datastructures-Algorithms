package DSGraph;

import java.util.*;
import DSGraph.Graph.Node;

public class CycleDirected {
    static Map<Graph.Node, List<Graph.Node>> adjList = new HashMap<>();
    static Map<String, Graph.Node> nodes = new HashMap<>();

    public static void main(String[] arg){
        // create Graph data
        Graph graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addEdges("D","A");
        graph.addEdges("A","B");
        graph.addEdges("B","C");
        graph.addEdges("C","A");
        adjList = graph.getAdjList();
        nodes = graph.getNodes();
        // depth search
        boolean hasACycle = hasCycle();
        System.out.println("Has Cycle :: "+hasACycle);
    }

    private static boolean hasCycle() {
        Set<Node> all = new HashSet<>();
        Set<Node> visiting = new HashSet<>();
        Set<Node> visited = new HashSet<>();

        all.addAll(nodes.values());
        while(!all.isEmpty()){
            Node current = all.iterator().next();
            boolean cycle = hasCycle(current, all, visiting, visited);
            if(cycle){
                return true;
            }
        }
        return false;
    }

    private static boolean hasCycle(Node current, Set<Node> all, Set<Node> visiting, Set<Node> visited) {
        all.remove(current);
        visiting.add(current);
        for(Node temp: adjList.get(current)){
            if(visited.contains(temp)){
                continue;
            }
            if(visiting.contains(temp)){
                return true;
            }
            if(hasCycle(temp, all, visiting, visited)){
                return true;
            }
        }
        visiting.remove(current);
        visited.add(current);
        return false;
    }
}
