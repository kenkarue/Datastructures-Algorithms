package DSGraph;

import SharedClasses.Edge;
import SharedClasses.Node;
import java.util.*;

import static sun.misc.Version.print;

public class Weighted {

    static Map<String, Node> nodes = new HashMap<>();
    static Map<Node, List<Edge>> adjList = new HashMap<>();

    public static void main(String[] args){
        Weighted weighedGraph = new Weighted();
        // add nodes
        weighedGraph.addNode("Kenya");
        weighedGraph.addNode("Uganda");
        weighedGraph.addNode("Tanzania");

        // add vertices
        weighedGraph.addEdge("Kenya", "Uganda", 30);
        weighedGraph.addEdge("Kenya", "Tanzania", 20);
        weighedGraph.addEdge("Tanzania", "Uganda", 10);

        print();
    }

    private static void addNode(String label){
        if(nodes.containsKey(label)){
           return;
        }
        Node newNode = new Node(label);
        nodes.put(label, newNode);
        adjList.putIfAbsent(newNode, new ArrayList<>());
    }

    private static void addEdge(String from, String to, int weight){
        if(!nodes.containsKey(from)){
            throw new IllegalArgumentException("Vertice "+ from +" does not exist");
        }
        if(!nodes.containsKey(to)){
            throw new IllegalArgumentException("Vertice "+ to +" does not exist");
        }
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);

        Edge fromEdge = new Edge(fromNode, toNode, weight);
        Edge toEdge = new Edge(toNode, fromNode, weight);

        adjList.get(fromNode).add(fromEdge);
        adjList.get(toNode).add(toEdge);
    }

    private static void print(){
//        for(Map.Entry<Node, List<Edge>> list: adjList.entrySet()){
//            Node key = list.getKey();
//            List<Edge> values = list.getValue();
//            System.out.println(key.label + " " +values.toString());
//        }
        for(List<Edge> values : adjList.values()){
            System.out.println(values.toString());
        }
    }
}
