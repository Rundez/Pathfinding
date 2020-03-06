import java.util.ArrayList;

public class Node {
    int n;
    String name;
    ArrayList<Edge> edges;
    boolean visited;


    Node(int n, String name){
        this.n = n;
        this.name = name;
        visited = false;
        edges = new ArrayList<Edge>();
    }

    void visit(){
        visited = true;
    }

    void unvisit(){
        visited = false;
    }

    boolean isVisited(){
        return visited;
    }

}
