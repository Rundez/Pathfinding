// A Java program for Prim's Minimum Spanning Tree (Primgraph) algorithm.
// The program is for adjacency matrix representation of the graph

class Primgraph {
    private static final int V = 6;
     int weight = 0;
     String name[] = {"A","B","C","D","E","F"};

    int minKey(int key[], Boolean mstSet[])
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (mstSet[v] == false && key[v] < min) {
                min = key[v];
                min_index = v;
            }

        return min_index;
    }

    void printMST(int parent[], int graph[][])
    {
        System.out.println("Edge \tWeight \t Totale kostnad");
        for (int i = 1; i < V; i++){
            weight = weight +  graph[i][parent[i]];
            System.out.println(parent[i] +" ( " + name[parent[i]] +" ) " + " - " + i + " ( " + name[i] +" ) " + "\t" + graph[i][parent[i]] + "\t      " + weight);


        }

    }

    void primMST(int graph[][])
    {
        int parent[] = new int[V];
        int key[] = new int[V];

        Boolean mstSet[] = new Boolean[V];

        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < V - 1; count++) {

            int u = minKey(key, mstSet);
            mstSet[u] = true;

            for (int v = 0; v < V; v++)
                if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
        }

        printMST(parent, graph);
    }

    public static void main(String[] args)
    {

        Primgraph t = new Primgraph();
        int graph[][] = new int[][] {
                { 0, 10, 5, 9999, 3, 12},   //A
                { 10, 0, 17, 9, 17, 12},    //B
                { 5, 17, 0, 35, 3 , 12},    //C
                { 9999, 9, 35, 0, 999 , 12},//D
                { 3, 17, 3, 999, 0, 12},    //E
                { 12, 12, 12, 12, 12 , 12}, //F
                 };

        t.primMST(graph);
    }
}

