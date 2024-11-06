package DesignQuestions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class LRUCache {

    class Node {
        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    LinkedList<Node> list;
    Map<Integer, Node> map;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        list = new LinkedList<>();
        map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        list.remove(node);
        list.addFirst(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            list.remove(node);
            node.value = value;
            list.addFirst(node);
        } else {
            Node newNode = new Node(key, value);
            if (map.size() >= capacity) {
                Node lru = list.removeLast();
                map.remove(lru.key);
            }
            list.addFirst(newNode);
            map.put(key, newNode);
        }
    }
}