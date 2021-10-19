
/**
 * MaximalNetworkFlow
 */
import java.util.*;
import java.util.Map.Entry;

@SuppressWarnings("unchecked")
public class MaximalNetworkFlow {

    public static int maximalNetworkRank(int n, int[][] roads) {
        if (roads == null)
            return 0;
        LinkedList<Integer>[] adj = new LinkedList[n];
        HashSet<Entry<Integer, Integer>> hash_set = new HashSet<>(); // set to store edges
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<Integer>();
        }

        for (int[] edge : roads) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
            hash_set.add(Map.entry(edge[0], edge[1]));
        }

        int max = 0;
        for (int i = 0; i < adj.length; i++) {
            for (int j = i + 1; j < adj.length; j++) {
                if (hash_set.contains(Map.entry(i, j)) || hash_set.contains(Map.entry(j, i))) {
                    max = Math.max(max, adj[i].size() + adj[j].size() - 1);
                } else {
                    max = Math.max(max, adj[i].size() + adj[j].size());
                }
            }
        }

        return max;

    }

    public static void main(String[] args) {
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 2, 4 }, { 5, 6 }, { 5, 7 } };

        int ans = maximalNetworkRank(8, edges);
        System.out.println(ans);
    }

}