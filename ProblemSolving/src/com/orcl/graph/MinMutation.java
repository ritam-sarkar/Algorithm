package com.orcl.graph;

import java.util.*;

public class MinMutation {


    private static int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> banks = new HashSet<>(Arrays.asList(bank));

        // Important check
        if (!banks.contains(endGene)) return -1;

        Queue<String> q = new ArrayDeque<>();
        q.offer(startGene);

        Set<String> visited = new HashSet<>();
        visited.add(startGene);

        int steps = 0;
        char[] genes = {'A', 'C', 'G', 'T'};

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                if (curr.equals(endGene)){
                    return steps;
                }
                char[] arr = curr.toCharArray();
                for (int j = 0; j < 8; j++) {
                    char old = arr[j];
                    for (char ch : genes) {
                        arr[j] = ch;
                        String next = new String(arr);
                        if (banks.contains(next) && !visited.contains(next)) {
                            visited.add(next);
                            q.offer(next);
                        }
                    }
                    arr[j] = old; // restore
                }
            }
            steps++;
        }

        return -1;
    }


    public static void main(String[] args) {
        System.out.println(minMutation("AACCGGTT","AAACGGTA", new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"}));
        System.out.println(minMutation("AACCGGTT","AACCGGTA", new String[]{"AACCGGTA"}));
    }
}
