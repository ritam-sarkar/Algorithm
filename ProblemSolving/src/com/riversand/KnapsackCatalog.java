package com.riversand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/**
 * Problem statement
 * I have a sack where 1 million records can be processed
 * each catalog has some records , I have n number of catalogs, which is a map
 * I need to process those catalogs which can cover up to 1 million and utilize the sack
 *
 */
public class KnapsackCatalog {
    public static void main(String[] args) {
        int[] records = {2, 200, 100, 200, 500000, 300000, 400000, 900000, 500000, 5000, 40000};
        int capacity = 2_000_000;

        BitSet dp = new BitSet(capacity + 1);
        dp.set(0);

        // parent[i] = index of catalog used to reach sum i
        int[] parent = new int[capacity + 1];
        Arrays.fill(parent, -1);

        for (int i = 0; i < records.length; i++) {
            int r = records[i];

            BitSet shifted = shiftLeft(dp, r, capacity);

            // Only process newly reachable states
            for (int s = shifted.nextSetBit(0); s >= 0; s = shifted.nextSetBit(s + 1)) {
                if (!dp.get(s)) { // newly formed sum
                    parent[s] = i;
                }
            }

            dp.or(shifted);
        }

        // Find best sum
        int max = dp.previousSetBit(capacity);
        System.out.println("Max records utilized = " + max);

        // 🔍 Backtrack to find catalogs
        List<Integer> selected = new ArrayList<>();
        int curr = max;

        while (curr > 0) {
            int idx = parent[curr];
            selected.add(idx);
            curr -= records[idx];
        }

        // Print result
        System.out.println("Selected catalogs:");
        for (int idx : selected) {
            System.out.println("Catalog index: " + idx +
                    ", records: " + records[idx]);
        }

    }
    public static BitSet shiftLeft(BitSet bs, int shift, int max) {
        BitSet result = new BitSet(max + 1);
        for (int i = bs.nextSetBit(0); i >= 0; i = bs.nextSetBit(i + 1)) {
            if (i + shift <= max) {
                result.set(i + shift);
            }
        }
        return result;
    }
}
