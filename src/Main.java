import java.util.ArrayList;
import java.util.Random;

public class Main {


    public static void main(String[] args) {

        Graph graph = new Graph(true);
        Node zero = new Node(0,"0");
        Node one = new Node(1,"1");
        Node two = new Node(2,"2");
        Node three = new Node(3,"3");
        Node four = new Node(4,"4");
        Node five = new Node(5,"5");
        Node six = new Node(6,"6");

        graph.addEdge(zero,one,8);
        graph.addEdge(zero,two,11);
        graph.addEdge(one,three,3);
        graph.addEdge(one,four,8);
        graph.addEdge(one,two,7);
        graph.addEdge(two,four,9);
        graph.addEdge(three,four,5);
        graph.addEdge(three,five,2);
        graph.addEdge(four,six,6);
        graph.addEdge(five,four,1);
        graph.addEdge(five,six,8);

        graph.Dijkstra(zero,six);


    }
}
