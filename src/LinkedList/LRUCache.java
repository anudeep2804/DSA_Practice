package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class Node{
        Node prev;
        Node next;
        int val;

        public Node(Node prev, Node next, int val) {
            this.prev = prev;
            this.next = next;
            this.val = val;
        }

    }
    int cap;
    HashMap<Integer,Node> map;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
       cap = capacity;
       map = new HashMap<>();
       head = new Node(null, tail, -1);
       tail = new Node(head, null, -1);
       head.next=tail;
       tail.prev = head;
    }

    public void addNode(Node node){

        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    public void deleteNode(Node node){

        node.prev.next = node.next;
        node.next.prev =node.prev;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            deleteNode(node);
            addNode(node);
            return node.val;
        }
        else{
            return -1;
        }
    }

    public void put(int key, int value) {

     if(map.containsKey(key)){
         Node curr = map.get(key);
         curr.val = value;
         deleteNode(curr);
         addNode(curr);
     }
     else{
         if (map.size() == cap) {
             // Capacity is full, remove the least recently used node (right before tail)
             Node lru = tail.prev;  // The least recently used node is before the tail
             deleteNode(lru);       // Remove from the linked list

             // To remove the LRU node from the map, we need to find its corresponding key
             int lruKey = -1;
             for (Map.Entry<Integer, Node> entry : map.entrySet()) {
                 if (entry.getValue() == lru) {
                     lruKey = entry.getKey();
                     break;
                 }
             }

             map.remove(lruKey);  // Remove the least recently used node from the map
         }

         Node newNode = new Node(null, null, value);
         addNode(newNode);
         map.put(key , newNode);
     }


    }
}
