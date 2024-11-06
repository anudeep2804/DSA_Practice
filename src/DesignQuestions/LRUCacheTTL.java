package DesignQuestions;

import java.util.*;

public class LRUCacheTTL {

    LinkedList<Integer> list;  // Store keys instead of Cache objects
    long TTL;
    int capacity;  // Changed to lowercase following Java conventions
    Map<Integer, Cache> map;

    class Cache {
        int key;    // Added key field
        int val;
        long expiryTime;

        Cache(int key, int val) {  // Modified constructor to include key
            this.key = key;
            this.val = val;
            this.expiryTime = System.currentTimeMillis() + TTL;
        }

        boolean isExpired() {
            return System.currentTimeMillis() > expiryTime;
        }
    }

    public LRUCacheTTL(int capacity, long ttl) {
        this.capacity = capacity;
        this.TTL = ttl;
        list = new LinkedList<>();
        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Cache currentCache = map.get(key);
            if (currentCache.isExpired()) {
                map.remove(key);
                list.remove((Integer) key);
                return -1;
            } else {
                list.remove((Integer) key);
                list.addFirst(key);  // Store only the key in list
                return currentCache.val;
            }
        }
        return -1;
    }

    public void put(int key, int value) {
        // Remove expired entries first
        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext()) {
            int currentKey = itr.next();
            Cache currentCache = map.get(currentKey);
            if (currentCache.isExpired()) {
                itr.remove();
                map.remove(currentKey);
            }
        }

        if (map.containsKey(key)) {
            list.remove((Integer) key);
            list.addFirst(key);
            map.put(key, new Cache(key, value));
        } else {
            if (map.size() >= capacity) {  // Changed == to >=
                int lruKey = list.removeLast();  // Remove from the end, not the beginning
                map.remove(lruKey);
            }
            list.addFirst(key);
            map.put(key, new Cache(key, value));
        }
    }
}