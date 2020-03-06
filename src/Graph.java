import javax.swing.plaf.IconUIResource;
import java.util.*;

class Graph {
    private Set<Node> nodes;
    private boolean directed;

    Graph(boolean directed) {
        this.directed = directed;
        nodes = new HashSet<>();
    }

    /**
     * Legger til node(er)
     * @param node hvilken node som skal bli lagt til, kan være flere noder representert med ...
     */
    void addNode(Node... node) {
        nodes.addAll(Arrays.asList(node));
    }

    /**
    * Legger til connection mellom nodene(vertexene)
    * @param source er startpunktet for tilkoblingen
    * @param destination er sluttpunktet for tilkoblingen
    * @param cost er kostnad det tar å bevege seg til noden
    * */
    void addEdge(Node source, Node destination, double cost) {
        nodes.add(source);
        nodes.add(destination);

        addEdgeHelper(source,destination,cost);

        if (!directed && source != destination){
            addEdgeHelper(source,destination,cost);
        }


    }

    /**
     *  Hjelper addEdge med å sjekke om det allerede er en tilkobling
     * @param src  Startpunktet for tilkoblingen
     * @param dest Sluttpunktet for tilkoblingen
     * @param cost Kostnaden for reisen mellom tilkoblingene
     */
    void addEdgeHelper(Node src, Node dest, double cost){
        for(Edge edge: src.edges){
            if (edge.getSource() == src && edge.getDestination() == dest ){
                edge.setCost(cost);
                return;
            }
        }

        src.edges.add(new Edge(src,dest,cost));
    }

    /**
     * Skriver ut tilkoblingene
     */
    void printEdges(){
        for (Node node: nodes){
            ArrayList<Edge> edges = node.edges;

            if (edges.isEmpty()){
                System.out.println("Node " + node.name + " has no connection");
                continue;
            }
            System.out.println("Node" + node.name + " has connections to: ");
            for (Edge edge: edges){
                System.out.println(edge.getDestination().name + " ( " + edge.getCost() + " ) ");
            }
            System.out.println();
        }
    }

    /**
     * Sjekker om det er en tilkobling tilstede
     * @param source  startpunktet for tilkobling
     * @param destination sluttpunktet
     * @return returnerer en boolean om den har tilkobling eller ei
     */
    boolean hasEdges(Node source, Node destination){
        ArrayList<Edge> edges = source.edges;
        for (Edge edge: edges){
            if(edge.getDestination() == destination){
                return true;
            }
        }
        return false;
    }

    /**
     * Setter alle noder til å ikke ha vært besøkt
     */
    void resetNodesVisited(){
        for (Node node: nodes){
            node.unvisit();
        }
    }

    /**
     * Dijksta algo logikken ligger i kodeblokken under den tar for seg et startpunkt og et sluttpunkt
     * @param start parameteret for startpunktet
     * @param end   parameteret for sluttpunktet
     */
    void Dijkstra(Node start, Node end){
        HashMap<Node, Node> changedAt = new HashMap<>();
        changedAt.put(start,null);
        HashMap<Node, Double> shortestPathMap = new HashMap<>();

        for(Node node: nodes){
            if(node == start){
                shortestPathMap.put(start,0.0); }

            else{
                shortestPathMap.put(node,Double.POSITIVE_INFINITY);}
        }
        for (Edge edge:start.edges){
                shortestPathMap.put(edge.getDestination(),edge.getCost());
                changedAt.put(edge.getDestination(),start);
        }
        start.visit();
    while (true){
        Node currentNode = closestReachableUnvisited(shortestPathMap);

        if (currentNode == null){
            System.out.println("There isnt a path " + start.name +" and " + end.name);
            return;
        }
        if (currentNode == end){
            System.out.println("The path with the smallest weight between "
                    + start.name + " and " + end.name + " is:");

            Node child = end;

            String path = end.name;
            while (true){
                Node parent = changedAt.get(child);
                if (parent == null){
                    break;
                }
                path = parent.name + " " + path;
                child = parent;
            }

            System.out.println(path);
            System.out.println("The path costs " + shortestPathMap.get(end));
            return;
        }
        currentNode.visit();
        for (Edge edge : currentNode.edges) {
            if (edge.getDestination().isVisited())
                continue;

            if (shortestPathMap.get(currentNode)
                    + edge.getCost()
                    < shortestPathMap.get(edge.getDestination())) {
                shortestPathMap.put(edge.getDestination(),
                        shortestPathMap.get(currentNode) + edge.getCost());
                changedAt.put(edge.getDestination(), currentNode);
                }
            }
        }
      }

      private Node closestReachableUnvisited(HashMap<Node,Double> shortestPathMap){
        double shortestDistance = Double.POSITIVE_INFINITY;
        Node closestReachableNode = null;
        for(Node node: nodes){
            if (node.isVisited()){
                continue;
            }

            double currentDistance = shortestPathMap.get(node);
            if(currentDistance == Double.POSITIVE_INFINITY){
                continue;
            }

            if (currentDistance < shortestDistance){
                shortestDistance = currentDistance;
                closestReachableNode = node;
            }
        }

        return closestReachableNode;
      }
    }




