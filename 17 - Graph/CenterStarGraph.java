import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;

public class CenterStarGraph {

    public static int findCenter(int[][] edges) {
        if (edges == null)
            return 0;

        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            LinkedList<Integer> temp = map.containsKey(edges[i][0]) ? map.get(edges[i][0]) : new LinkedList<>();
            temp.add(edges[i][1]);
            map.put(edges[i][0], temp);

            temp = map.containsKey(edges[i][1]) ? map.get(edges[i][1]) : new LinkedList<>();
            temp.add(edges[i][0]);
            map.put(edges[i][1], temp);
        }

        for (Map.Entry<Integer, LinkedList<Integer>> l : map.entrySet()) {

            if (l.getValue().size() == map.size() - 1)
                return l.getKey();

        }
        return -1;

    }

    public static void main(String[] args) {

        int[][] edges = { { 10, 1 }, { 10, 2 }, { 3, 10 }, { 10, 4 }, { 5, 10 }, { 10, 6 }, { 10, 7 }, { 8, 10 },
                { 10, 9 }, { 10, 11 }, { 12, 10 }, { 10, 13 }, { 14, 10 } };
        int ans = findCenter(edges);

        System.out.println(ans);

    }

}
