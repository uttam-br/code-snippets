package disjointset;

import java.util.*;

public class Main {

    private static int nodes = 5;
    private static List<List<Integer>> edges;

    public static void main(String[] args) {
        edges = new ArrayList<>();
        edges.add(List.of(0, 1));
        edges.add(List.of(1, 2));
        // edges.add(List.of(3, 4));
        // edges.add(List.of(3, 2));

        System.out.println("Number of connected components " + getNumberOfConnectedComponents());
    }

    private static int getNumberOfConnectedComponents() {
        DisjointSet disjointset = new DisjointSet(nodes, edges);
        return disjointset.getNumberOfLeaders();
    }

}
