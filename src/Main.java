import java.util.ArrayList;
import java.util.Random;

public class Main {


    public static void main(String[] args) {

        Graph graph = new Graph(true);
        Node A = new Node(0,"A");
        Node B = new Node(1,"B");
        Node C = new Node(2,"C");
        Node D = new Node(3,"D");
        Node E = new Node(4,"E");
        Node F = new Node(5,"F");

        //Nodene fra A -> til BCDEF
        graph.addEdge(A,B,10);
        graph.addEdge(A,C,5);
        graph.addEdge(A,D,9999);
        graph.addEdge(A,E,3);
        graph.addEdge(A,F,12);

        //Nodene fra B -> til ACDEF
        graph.addEdge(B,A,10);
        graph.addEdge(B,C,17);
        graph.addEdge(B,D,9);
        graph.addEdge(B,E,17);
        graph.addEdge(B,F,12);

        //Nodene fra C -> til ABDEF
        graph.addEdge(C,A,5);
        graph.addEdge(C,B,17);
        graph.addEdge(C,D,35);
        graph.addEdge(C,E,3);
        graph.addEdge(C,F,12);

        //Nodene fra D -> til ABCEF
        graph.addEdge(D,A,9999);
        graph.addEdge(D,B,9);
        graph.addEdge(D,C,35);
        graph.addEdge(D,E,999);
        graph.addEdge(D,F,12);

        //Nodene fra E -> til ABCDF
        graph.addEdge(E,A,3);
        graph.addEdge(E,B,17);
        graph.addEdge(E,C,3);
        graph.addEdge(E,D,999);
        graph.addEdge(E,F,12);

        //Nodene fra F -> tl ABCDE
        graph.addEdge(F,A,12);
        graph.addEdge(F,B,12);
        graph.addEdge(F,C,12);
        graph.addEdge(F,D,12);
        graph.addEdge(F,E,12);

        graph.printEdges();
        graph.Dijkstra(A,B);
        graph.resetNodesVisited();
        graph.Dijkstra(A,C);
        graph.resetNodesVisited();
        graph.Dijkstra(A,E);
        graph.resetNodesVisited();
        graph.Dijkstra(A,F);
        graph.resetNodesVisited();

        graph.Dijkstra(B,C);
        graph.resetNodesVisited();
        graph.Dijkstra(B,D);
        graph.resetNodesVisited();
        graph.Dijkstra(B,E);
        graph.resetNodesVisited();
        graph.Dijkstra(B,F);
        graph.resetNodesVisited();


        graph.Dijkstra(C,D);
        graph.resetNodesVisited();
        graph.Dijkstra(C,E);
        graph.resetNodesVisited();
        graph.Dijkstra(C,F);
        graph.resetNodesVisited();

        graph.Dijkstra(D,F);
        graph.resetNodesVisited();
        graph.Dijkstra(E,F);
        graph.resetNodesVisited();
        graph.Dijkstra(A,D);

        Primgraph t = new Primgraph();
        int graphs[][] = new int[][] {
                { 0, 10, 5, 9999, 3, 12},   //A
                { 10, 0, 17, 9, 17, 12},    //B
                { 5, 17, 0, 35, 3 , 12},    //C
                { 9999, 9, 35, 0, 999 , 12},//D
                { 3, 17, 3, 999, 0, 12},    //E
                { 12, 12, 12, 12, 12 , 12}, //F
        };

        t.primMST(graphs);

    }
}
