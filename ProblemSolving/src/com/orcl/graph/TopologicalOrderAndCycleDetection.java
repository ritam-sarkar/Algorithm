package com.orcl.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TopologicalOrderAndCycleDetection {

    public static void kahnTopo(int n, int[][] edges) {
        // Step 1: Build graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        int[] indegree = new int[n];

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            graph.get(u).add(v);
            indegree[v]++;
        }

        // Step 2: Queue for indegree 0
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        // Step 3: BFS
        List<Integer> topo = new ArrayList<>();
        int count = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            topo.add(curr);
            count++;

            for (int next : graph.get(curr)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        // Step 4: Cycle check
        if (count != n) {
            System.out.println("Cycle detected ❌");
        } else {
            System.out.println("No cycle ✅");
            System.out.println("Topological Order: " + topo);
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {
                {5, 2},
                {5, 0},
                {4, 0},
                {4, 1},
                {2, 3},
                {3, 1}
        };

        kahnTopo(n, edges);
        edges = new int[][]{
                {0,1},
                {1,2},
                {2,0}
        };
        kahnTopo(3, edges);

    }
}
