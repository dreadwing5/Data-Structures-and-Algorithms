import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedHashSet;

public class BFS {

    LinkedHashSet<Integer> hash_set = new LinkedHashSet<>();
    Deque<Integer> queue = new ArrayDeque<>();

    public void bfs(Graph g, int src) {
        int dst = 5;

        int[] dist = new int[g.V];
        int[] parent = new int[g.V];

        int ele;
        queue.add(src);
        hash_set.add(src);

        dist[src] = 0;
        parent[src] = -1;

        while (!queue.isEmpty()) {
            ele = queue.poll();
            for (Integer node : g.adj[ele]) {
                if (!hash_set.contains(node)) {
                    queue.add(node);
                    hash_set.add(node);
                    parent[node] = ele;
                    dist[node] = dist[ele] + 1; // distance of current node = dist of parent + 1
                }

            }
        }

        // Print the minimum distance
        for (int i = 0; i < dist.length; i++) {

            System.out.println("Shortest distance to " + i + " is " + dist[i]);

        }

        // print the path to destination

        System.out.println("The shortest path from " + src + " " + dst + " is ");
        while (dst != -1) {
            System.out.print(dst + " , ");
            dst = parent[dst];
        }
        System.out.println();

    }

    public static void main(String[] args) {
        Graph g = new Graph(7);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(3, 5);
        g.addEdge(5, 6);
        g.addEdge(4, 5);
        g.addEdge(0, 4);
        g.addEdge(3, 4);

        g.printGraph();

        BFS b = new BFS();
        b.bfs(g, 1);

    }

}
