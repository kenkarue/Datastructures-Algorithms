package DSGraph;

import SharedClasses.Edge;
import SharedClasses.Node;

import java.util.*;

import static DSGraph.Weighted.getAdjList;
import static DSGraph.Weighted.getNodes;

public class CycleUnDirected {

    static Map<String, Node> nodes;
    static Map<Node, List<Edge>> adjList;

    public static void main(String[] args){
        // create graph
        createUndirectedGraph();
        nodes = getNodes();
        adjList = getAdjList();

        //check cycle
        boolean cycle = hasCycle();
        System.out.println("HasCycle -> "+cycle);
    }

    private static boolean hasCycle() {
        if(nodes.isEmpty()){
            return false;
        }
        Set<Node> visited =  new HashSet<>();
        for (Node current : nodes.values()) {
            if(!visited.contains(current)){
                boolean cycle = hasCycle(visited, null, current);
                if(cycle)
                    return true;
            }
        }
        return false;
    }

    private static boolean hasCycle(Set<Node> visited, Node parent, Node current) {
        System.out.println(current.label);
        visited.add(current);
        for(Edge edges: adjList.get(current)){
            if(edges.to == parent){
                // no going back to parent
                continue;
            }
            if(visited.contains(edges.to)){
                // cycle
                return true;
            }
            if(hasCycle(visited, current, edges.to)){
                return true;
            }
        }
        return false;
    }

    private static void createUndirectedGraph() {
        Weighted weighedGraph = new Weighted();
        // add nodes
        weighedGraph.addNode("A");
        weighedGraph.addNode("B");
        weighedGraph.addNode("C");
        weighedGraph.addNode("D");

        // add vertices
        weighedGraph.addEdge("A", "B", 1);
        weighedGraph.addEdge("A", "C", 1);
        weighedGraph.addEdge("B", "D", 1);
    }
}
