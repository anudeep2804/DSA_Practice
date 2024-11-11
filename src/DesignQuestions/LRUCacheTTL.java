package DesignQuestions;

import java.util.*;

public class LRUCacheTTL {

    private LinkedList<Cache> list;  // Store Cache objects in usage order
    private Map<Integer, Cache> map; // Store key -> Cache mapping
    private long TTL;                // Time-to-live in milliseconds
    private int capacity;            // Cache capacity

    // Cache class to store key, value, and expiry time
    class Cache {
        int key;
        int val;
        long expiryTime;

        Cache(int key, int val) {
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
        this.list = new LinkedList<>();
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1; // Key not found
        }

        Cache cache = map.get(key);
        if (cache.isExpired()) {
            // Remove expired entry
            removeCache(cache);
            return -1;
        }

        // Move accessed cache to the front of the list
        list.remove(cache);
        list.addFirst(cache);
        return cache.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // Update existing entry and reset expiry
            Cache cache = map.get(key);
            cache.val = value;
            cache.expiryTime = System.currentTimeMillis() + TTL;

            // Move it to the front of the list
            list.remove(cache);
            list.addFirst(cache);
        } else {
            if (map.size() >= capacity) {
                // Evict least recently used (last in the list)
                Cache lruCache = list.removeLast();
                map.remove(lruCache.key);
            }

            // Add new cache entry
            Cache newCache = new Cache(key, value);
            list.addFirst(newCache);
            map.put(key, newCache);
        }

        // Remove expired items lazily if they exist
        removeExpiredItems();
    }

    private void removeCache(Cache cache) {
        list.remove(cache);  // Remove from list
        map.remove(cache.key); // Remove from map
    }

    private void removeExpiredItems() {
        Iterator<Cache> iterator = list.iterator();
        while (iterator.hasNext()) {
            Cache cache = iterator.next();
            if (cache.isExpired()) {
                iterator.remove();
                map.remove(cache.key);
            } else {
                break; // Stop since the rest will be in order
            }
        }
    }
}
