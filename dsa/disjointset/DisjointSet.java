package disjointset;

import java.util.*;

public class DisjointSet {

    private int components;
    private int[] leaders;
    private int[] ranks;

    DisjointSet(int nodes, List<List<Integer>> edges) {
        components = nodes;
        leaders = new int[nodes];
        ranks = new int[nodes];

        for (int i=0; i<nodes; i++) {
            leaders[i] = i;
            ranks[i] = 1;
        }

        for (List<Integer> edge : edges) {
            int v1 = edge.get(0);
            int v2 = edge.get(1);
            union(v1, v2);
        }
    }

    public void union(int n1, int n2) {
        int n1Leader = find(n1);
        int n2Leader = find(n2);

        if (n1Leader != n2Leader) {
            if (ranks[n1Leader] > ranks[n2Leader]) {
                // attach n2 to n1
                leaders[n2Leader] = n1Leader;
            } else if (ranks[n1Leader] < ranks[n2Leader]) {
                leaders[n1Leader] = n2Leader;
            } else {
                leaders[n2Leader] = n1Leader;
                ranks[n1Leader]++;
            }
            components--;
        }
    }
    
    public int find(int n) {
        if (leaders[n] == n) {
            return n;
        }
        int leader = find(leaders[n]);
        // path compression
        leaders[n] = leader;
        return leader;
    }

    public int getNumberOfLeaders() {
        return components;
    }

}
