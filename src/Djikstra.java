import java.util.*;
public class Djikstra {
    private int dist[];
    private Set<Integer> checked;
    private PriorityQueue<N> que;
    private int V;
    List<List<N>> adj;

    public DPQ(int V){
        this.V = V;
        dist = new int[V];
        checked = new HashSet<Integer>();
        que = new PriorityQueue<Node>(V, new N());
    }
    public void djikstra(List<List<N>> adj, int src){
        this.adj = adj;

        for (int i = 0; i < V; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        que.add(new N(src, 0));
    }
}
