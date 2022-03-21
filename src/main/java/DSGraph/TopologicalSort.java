package DSGraph;

import java.util.*;
import DSGraph.Graph.Node;

/**
 * Topological Sort
 *  Input::
 *      ---> A --->
 *   X              P
 *      ---> B --->
 *   OutPut::
 *   XABP
 *   XBAP
 */
public class TopologicalSort {

    static Map<Graph.Node, List<Graph.Node>> adjList = new HashMap<>();
    static Map<String, Graph.Node> nodes = new HashMap<>();

    public static void main(String[] args){
        // create Graph data
        Graph graph = new Graph();
        graph.addNode("X");
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("P");
        graph.addEdges("X","A");
        graph.addEdges("X","B");
        graph.addEdges("A","P");
        graph.addEdges("B","P");
        adjList = graph.getAdjList();
        nodes = graph.getNodes();
        //
        List<Node> sorted = topologicalSort("X");
        System.out.print(sorted);
    }

    private static List<Node> topologicalSort(String start){
        Node current = nodes.get(start);
        if(current == null){
            return new ArrayList<>();
        }
        Stack<Node> stack = new Stack();
        topologicalSort(nodes.get(start), stack, new HashSet<>());
        List<Node> topSort = new ArrayList<>();
        while(!stack.isEmpty()){
           topSort.add(stack.pop());
        }
        return topSort;
    }

    private  static void topologicalSort(Node current, Stack<Node> top, Set<Node> visited) {
        visited.add(current);
        for(Node temp: adjList.get(current)){
            if(!visited.contains(temp)){
                topologicalSort(temp, top,visited);
            }
        }
        top.add(current);
    }
}
