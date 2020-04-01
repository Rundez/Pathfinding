// A Java program for Prim's Minimum Spanning Tree (Primgraph) algorithm.
// The program is for adjacency matrix representation of the graph

class Primgraph {
    // Number of vertices in the graph
    private static final int V = 6;
     int weight = 0;
     String name[] = {"A","B","C","D","E","F"};
    // A utility function to find the vertex with minimum key
    // value, from the set of vertices not yet included in Primgraph
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

    // A utility function to print the constructed Primgraph stored in
    // parent[]
    void printMST(int parent[], int graph[][])
    {
        System.out.println("Edge \tWeight \t Totale kostnad");
        for (int i = 1; i < V; i++){
            weight = weight +  graph[i][parent[i]];
            System.out.println(parent[i] +" ( " + name[parent[i]] +" ) " + " - " + i + " ( " + name[i] +" ) " + "\t" + graph[i][parent[i]] + "\t      " + weight);


        }

    }

    // Function to construct and print Primgraph for a graph represented
    // using adjacency matrix representation
    void primMST(int graph[][])
    {
        // Array to store constructed Primgraph
        int parent[] = new int[V];

        // Key values used to pick minimum weight edge in cut
        int key[] = new int[V];

        // To represent set of vertices not yet included in Primgraph
        Boolean mstSet[] = new Boolean[V];

        // Initialize all keys as INFINITE
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        // Always include first 1st vertex in Primgraph.
        key[0] = 0; // Make key 0 so that this vertex is
        // picked as first vertex
        parent[0] = -1; // First node is always root of Primgraph

        // The Primgraph will have V vertices
        for (int count = 0; count < V - 1; count++) {
            // Pick thd minimum key vertex from the set of vertices
            // not yet included in Primgraph
            int u = minKey(key, mstSet);

            // Add the picked vertex to the Primgraph Set
            mstSet[u] = true;

            // Update key value and parent index of the adjacent
            // vertices of the picked vertex. Consider only those
            // vertices which are not yet included in Primgraph
            for (int v = 0; v < V; v++)

                // graph[u][v] is non zero only for adjacent vertices of m
                // mstSet[v] is false for vertices not yet included in Primgraph
                // Update the key only if graph[u][v] is smaller than key[v]
                if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
        }

        // print the constructed Primgraph
        printMST(parent, graph);
    }

    public static void main(String[] args)
    {

        Primgraph t = new Primgraph();
        int graph[][] = new int[][] {
                { 0, 10, 5, 9999, 3, 12},//A
                { 10, 0, 17, 9, 17, 12},//B
                { 5, 17, 0, 35, 3 , 12},//C
                { 9999, 9, 35, 0, 999 , 12},//D
                { 3, 17, 3, 999, 0, 12},//E
                { 12, 12, 12, 12, 12 , 12},//F
                 };

        t.primMST(graph);
    }
}

