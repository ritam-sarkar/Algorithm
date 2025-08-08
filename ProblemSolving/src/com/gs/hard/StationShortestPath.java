package com.gs.hard;

/**
 * Implement def shortestPath(self, fromStationName, toStationName)
 * method to find shortest path between 2 stations
 */

/*
 *      Visual representation of the Train map used
 *
 *      King's Cross St Pancras --- Angel ---- Old Street
 *      |                   \                            |
 *      |                    \                            |
 *      |                     \                            |
 *      Russell Square         Farringdon --- Barbican --- Moorgate
 *      |                                                  /
 *      |                                                 /
 *      |                                                /
 *      Holborn --- Chancery Lane --- St Paul's --- Bank
 */

/**
 A=[B, C, D], B=[A, E], C=[A, F], D=[A, G], E=[B, H], F=[C, K], G=[D, K], H=[E, I], I=[H, J], J=[I, K], K=[F, G, J]
 */

import java.util.*;


public class StationShortestPath {
    private final Map<Character, List<Character>> graph;

    public StationShortestPath() {
        graph = new HashMap<>();
        buildGraph();
        System.out.println(graph);
    }

    private void buildGraph() {
        // A: King's Cross St Pancras
        // B: Russell Square
        // C: Angel
        // D: Farringdon
        // E: Holborn
        // F: Old Street
        // G: Barbican
        // H: Chancery Lane
        // I: St Paul's
        // J: Bank
        // K: Moorgate

        addConnection('A', 'B');
        addConnection('A', 'C');
        addConnection('A', 'D');
        addConnection('C', 'F');
        addConnection('F', 'K');
        addConnection('B', 'E');
        addConnection('E', 'H');
        addConnection('H', 'I');
        addConnection('I', 'J');
        addConnection('D', 'G');
        addConnection('G', 'K');
        addConnection('J', 'K');
    }

    private void addConnection(char station1, char station2) {
        graph.computeIfAbsent(station1, k -> new ArrayList<>()).add(station2);
        graph.computeIfAbsent(station2, k -> new ArrayList<>()).add(station1);
    }

    public List<Character> shortestPath(char fromStation, char toStation) {
        if (fromStation == toStation) {
            return Arrays.asList(fromStation);
        }

        Queue<Character> queue = new LinkedList<>();
        Map<Character, Character> childToParentMap = new HashMap<>();
        Set<Character> visited = new HashSet<>();

        queue.add(fromStation);
        visited.add(fromStation);
        childToParentMap.put(fromStation, null);

        while (!queue.isEmpty()) {
            char current = queue.poll();
            if (current == toStation) {
                return reconstructPath(childToParentMap, toStation);
            }

            for (char neighbor : graph.getOrDefault(current, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    childToParentMap.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        return Collections.emptyList();
    }

    private List<Character> reconstructPath(Map<Character, Character> childToParentMap, char toStation) {
        LinkedList<Character> path = new LinkedList<>();
        Character current = toStation; // Use Character instead of char
        while (current != null) { // Now safe for null checks
            path.addFirst(current);
            current = childToParentMap.get(current);
        }
        return path;
    }
    public static void main(String[] args) {
        StationShortestPath trainMap = new StationShortestPath();
        System.out.println(trainMap.shortestPath('A', 'J')); // A → B → E → H → I → J
        System.out.println(trainMap.shortestPath('C', 'J')); // C → F → K → J
        System.out.println(trainMap.shortestPath('E', 'J')); // E → H → I → J
    }
}
