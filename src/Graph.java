import java.util.Arrays;
import java.util.Set;

class Graph {
    private Set<Node> nodes;
    private boolean directed;

    Graph() {

    }

    void addNode(Node... node) {
        nodes.addAll(Arrays.asList(node));
    }

    void addEdge(Node node) {

    }
}

