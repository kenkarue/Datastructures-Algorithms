package DSGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Graph implementation of countries
 */
public class Graph {

    // map helps us check if node already exist
    Map<String, Node> nodes = new HashMap<>();
    Map<Node, List<Node>> adjList = new HashMap<>();

    public class Node {
        String label;
        Node(String label){
            this.label = label;
        }

        @Override
        public String toString(){
            return label;
        }
    }

    /**
     * This adds country nodes/vertices
     */
    public void addNode(String label){
        Node newNode = new Node(label);
        nodes.putIfAbsent(label, newNode);
        adjList.putIfAbsent(newNode, new ArrayList<>());
    }

    /**
     * Add the edges for the nodes/vertices
     */
    public void addEdges(String from, String to){
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        if(fromNode == null){
            throw new IllegalArgumentException("Vertice "+from+" does not exist");
        }
        if(toNode == null){
            throw new IllegalArgumentException("Vertice "+to+" does not exist");
        }
        adjList.get(fromNode).add(toNode);
    }

    public void removeNode(String label){
        Node temp = nodes.get(label);
        if(temp == null){
            return;
        }
        adjList.remove(temp);
        nodes.remove(label);
        for(Map.Entry<Node,List<Node>> elements: adjList.entrySet()){
            elements.getValue().remove(temp);
        }
    }

    public void removeEdge(String from, String to){
        Node fromNode =  nodes.get(from);
        Node toNode =  nodes.get(to);
        if(fromNode == null || toNode == null){
            return;
        }
        adjList.get(fromNode).remove(toNode);
    }

    public void print(){
        for(Map.Entry elements: adjList.entrySet()){
            Node key = (Node) elements.getKey();
            List<Node> adj = (List) elements.getValue();
            System.out.println(key.label+ " is connected to "+adj.toString());
        }
    }

    public Map<Node, List<Node>> getAdjList() {
        return adjList;
    }

    public Map<String, Node> getNodes() {
        return nodes;
    }

    public static void main(String[] args){
        Graph graph = new Graph();
        graph.addNode("Kenya");
        graph.addNode("Uganda");
        graph.addNode("Tanzania");
        graph.addNode("Sudan");
        graph.addEdges("Kenya","Uganda");
        graph.addEdges("Kenya","Tanzania");
        graph.addEdges("Uganda","Tanzania");
        graph.addEdges("Sudan","Kenya");
        graph.addEdges("Sudan","Uganda");
        graph.addEdges("Sudan","Tanzania");
        graph.print();

        System.out.println("----------");
        graph.removeEdge("Sudan","Tanzania");
        graph.print();

        System.out.println("----------");
        graph.removeNode("Kenya");
        graph.print();
    }
}
