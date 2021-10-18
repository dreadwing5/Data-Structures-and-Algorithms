import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Graph1 {

    static class Node {
        String city;
        ArrayList<String> ngbr;

        public Node(String city) {
            this.city = city;
            ngbr = new ArrayList<>();
        }
    }

    boolean undir;
    HashMap<String, Node> adj;

    public Graph1(ArrayList<String> cities, boolean undir) {
        this.undir = undir;
        adj = new HashMap<>();
        for (String city : cities) {
            adj.put(city, new Node(city));
        }
    }

    public void addEdge(String x, String y) {
        adj.get(x).ngbr.add(y);
        if (undir)
            adj.get(y).ngbr.add(x);
    }

    public void printAdjList() {
        for (Map.Entry<String, Node> cityPair : adj.entrySet()) {
            System.out.println(cityPair.getKey() + " ---> " + cityPair.getValue().ngbr);
        }

    }
}

public class adj_list_02 {

    public static void main(String[] args) {

        ArrayList<String> cities = new ArrayList<>(Arrays.asList("Delhi", "London", "Paris", "New York"));

        Graph1 g = new Graph1(cities, false);
        g.addEdge("Delhi", "London");
        g.addEdge("New York", "London");
        g.addEdge("Delhi", "Paris");
        g.addEdge("Paris", "New York");

        g.printAdjList();
    }
}

/*
 * Alternate way of achieving the same result, see notes for more details
 */

// class Graph1 {
// boolean undir;
// HashMap<String, ArrayList<String>> adj;
// ArrayList<String> ngbr;

// public Graph1(ArrayList<String> cities, boolean undir) {
// this.undir = undir;
// adj = new HashMap<>();
// for (String city : cities) {
// ngbr = new ArrayList<>();
// adj.put(city, ngbr);
// }
// }

// public void addEdge(String x, String y) {
// adj.get(x).add(y);
// if (undir)
// adj.get(y).add(x);
// }

// public void printAdjList() {
// for (Map.Entry<String, ArrayList<String>> cityPair : adj.entrySet()) {
// System.out.println(cityPair.getKey() + " ---> " + cityPair.getValue());
// }

// }
// }

// public class AdjList {

// public static void main(String[] args) {

// ArrayList<String> cities = new ArrayList<>(Arrays.asList("Delhi", "London",
// "Paris", "New York"));

// Graph1 g = new Graph1(cities, false);
// g.addEdge("Delhi", "London");
// g.addEdge("New York", "London");
// g.addEdge("Delhi", "Paris");
// g.addEdge("Paris", "New York");

// g.printAdjList();
// }
// }
