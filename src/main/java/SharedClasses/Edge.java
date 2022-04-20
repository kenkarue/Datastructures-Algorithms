package SharedClasses;

public class Edge {

    public Node from;
    public Node to;
    public int weight;

    public Edge(Node from, Node to, int weight){
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public String toString(){
        return from.label + " -> " + to.label +" -> " + weight;
    }
}
