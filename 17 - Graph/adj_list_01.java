import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("unchecked")
class Graph2 {

    private final int V; // number of vertices
    private ArrayList<Integer>[] adj; // adjacency lists

    public Graph2(int V) {
        this.V = V;
        adj = new ArrayList[V];

        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<Integer>();
        }
    }

    void addEdge(int u, int v, boolean undir) {
        adj[u].add(v);
        if (undir)
            adj[v].add(u);
    }

    public void printAdjList() {
        for (int i = 0; i < V; i++) {
            System.out.print(i + " ---> ");

            System.out.println(adj[i]);
        }

    }
}

class adj_list_01 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        int vertices = scn.nextInt();
        System.out.println("Enter the number of edges");
        int edges = scn.nextInt();
        Graph2 g = new Graph2(vertices);

        System.out.println("Enter the edges (node1, node2) : ");
        for (int i = 0; i < edges; i++) {
            int x = scn.nextInt(), y = scn.nextInt();

            g.addEdge(x, y, true); // node1, node2, weight
        }

        g.printAdjList();
        scn.close();
    }

}
