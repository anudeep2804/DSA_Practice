package ArraysandHashing;

// Design an hashmap ;

import java.util.LinkedList;

public class MyHashMap {

    static final int numofBuckets = 1000;
    LinkedList<Entry> Buckets[];


    public MyHashMap() {

        Buckets = new LinkedList[numofBuckets];
        for(int i=0; i<numofBuckets; i++){
            Buckets[i]= new LinkedList<Entry>();
        }
    }

    public void put(int key, int value) {

        int index = key % numofBuckets;

        LinkedList<Entry> bucket = Buckets[index];

        for(Entry entry : bucket){
            if(entry.key==key){
                entry.value= value;
                return;
            }

        }

       bucket.add(new Entry(value, key));


    }

    public int get(int key) {

        int index = key % numofBuckets;
        LinkedList<Entry> bucket = Buckets[index];

        for(Entry entry : bucket){
            if(entry.key==key)
                return entry.value;
        }

        return -1;
    }

    public void remove(int key) {
        int index = key % numofBuckets;
        LinkedList<Entry> bucket = Buckets[index];

        for(Entry entry : bucket){
            if(entry.key == key){
                bucket.remove(entry);
                break;
            }

        }
    }
}

class Entry{

    int key;
     int value;
    Entry next;

    Entry(int value , int key){
        this.key=key;
        this.value=value;
    }
}
