import java.util.LinkedList;

@SuppressWarnings("unchecked")
class Graph {
    int V;
    boolean undir = true;
    LinkedList<Integer>[] adj;

    Graph(int v) {
        V = v;
        adj = new LinkedList[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    Graph(int v, boolean undir) {
        this(v);
        this.undir = undir; // directed/undirected , default : undirected
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
        if (undir)
            adj[v].add(u);
    }

    public void printGraph() {
        for (int i = 0; i < adj.length; i++) {
            System.out.println(i + " ------> " + adj[i]);
        }
    }

}
