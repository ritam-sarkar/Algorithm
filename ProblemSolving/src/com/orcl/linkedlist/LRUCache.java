package com.orcl.linkedlist;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer, Node> cache;

    private Node head, tail; // dummy nodes

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();

        // Initialize dummy head & tail
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    // 🔥 GET
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);

        // Move to front (MRU)
        remove(node);
        insertAtFront(node);

        return node.value;
    }

    // 🔥 PUT
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;

            remove(node);
            insertAtFront(node);
        } else {
            if (cache.size() == capacity) {
                // Remove LRU (tail.prev)
                Node lru = tail.prev;
                remove(lru);
                cache.remove(lru.key);
            }

            Node newNode = new Node(key, value);
            insertAtFront(newNode);
            cache.put(key, newNode);
        }
    }

    // 🔧 Remove node from DLL
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // 🔧 Insert node right after head (MRU position)
    private void insertAtFront(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        System.out.println("get"+lruCache.get(2));
        lruCache.put(2,6);
        System.out.println("get"+lruCache.get(1));
        lruCache.put(1,5);
        lruCache.put(1,2);
        System.out.println("get"+lruCache.get(1));
        System.out.println("get"+lruCache.get(2));

    }
}
