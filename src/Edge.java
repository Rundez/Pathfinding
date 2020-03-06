public class Edge implements Comparable<Edge> {
    private Node destination;
    private Node source;
    private int cost;

    public Edge(Node source, Node destination, int cost) {
        this.source = source;
        this.destination = destination;
        this.cost = cost;
    }


    public Node getDestination() {
        return destination;
    }

    public void setDestination(Node destination) {
        this.destination = destination;
    }

    public Node getSource() {
        return source;
    }

    public void setSource(Node source) {
        this.source = source;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge otherEdge) {
        if (this.cost > otherEdge.cost) {
            return 1;
        } else {
            return 0;
        }
    }
}
