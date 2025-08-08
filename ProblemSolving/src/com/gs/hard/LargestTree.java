package com.gs.hard;
/*
 **  Instructions:
 **
 **  Given a forest ( one or more disconnected trees ), find the root of largest tree
 **  and return its Id. If there are multiple such roots, return the smallest Id of them.
 **
 **  Complete the largestTree function in the editor below.
 **  It has one parameter, immediateParent, which is a map containing key-value pair indicating
 **  child -> parent relationship. The key is child and value is the corresponding
 **  immediate parent.
 **  Constraints
 **    - Child cannot have more than one immediate parent.
 **    - Parent can have more than one immediate child.
 **    - The given key-value pair forms a well-formed forest ( a tree of n nodes will have n-1 edges )
 **
 **  Example:
 **
 **  Input:
 **  { { 1 -> 2 }, { 3 -> 4} }
 **
 **  Expected output: 2
 **  Explanation: There are two trees one having root of Id 2 and another having root of Id 4.
 **  Both trees have size 2. The smaller number of 2 and 4 is 2. Hence the answer is 2.
 */


import java.util.*;

public class LargestTree {
    public static Integer largestTree(Map<Integer, Integer> immediateParent) {
        if (immediateParent.isEmpty()) {
            return null;
        }

        // Check for duplicate children (invalid input)
        Set<Integer> children = new HashSet<>();
        for (int child : immediateParent.keySet()) {
            if (!children.add(child)) {
                throw new IllegalArgumentException("Child " + child + " has multiple parents.");
            }
        }

        // Find roots (nodes not present as children)
        Set<Integer> allNodes = new HashSet<>();
        allNodes.addAll(immediateParent.keySet());
        allNodes.addAll(immediateParent.values());
        Set<Integer> roots = new HashSet<>(immediateParent.values());
        roots.removeAll(immediateParent.keySet());

        // Build parent-to-children map
        Map<Integer, Set<Integer>> parentToChildren = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : immediateParent.entrySet()) {
            int child = entry.getKey();
            int parent = entry.getValue();
            parentToChildren.computeIfAbsent(parent, k -> new HashSet<>()).add(child);
        }

        // Calculate tree sizes and find the largest root
        int maxSize = -1;
        int result = Integer.MAX_VALUE;
        for (int root : roots) {
            int size = calculateTreeSize(root, parentToChildren);
            if (size > maxSize) {
                maxSize = size;
                result = root;
            } else if (size == maxSize) {
                result = Math.min(result, root);
            }
        }
        return result;
    }

    private static int calculateTreeSize(int root, Map<Integer, Set<Integer>> parentToChildren) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        int size = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            size++;
            if (parentToChildren.containsKey(current)) {
                for (int child : parentToChildren.get(current)) {
                    queue.add(child);
                }
            }
        }

        return size;
    }

    public static void main(String[] args) {
        Map<Integer, Integer> immediateParent = new HashMap<>();
        immediateParent.put(2, 1);
        immediateParent.put(4, 3);
        immediateParent.put(6, 5);
        immediateParent.put(3, 1);
        System.out.println(largestTree(immediateParent)); // Expected output: 2
    }
}

