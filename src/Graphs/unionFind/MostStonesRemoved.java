package Graphs.unionFind;

//leetcode 947


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// assume all rows to be 0 - len and all colums will be len + 1 -> len + colNo


public class MostStonesRemoved {

    public int removeStones(int[][] stones) {

       int maxRow = 0;
       int maxCol = 0;
       int n = stones.length;

       for(int i=0; i<n; i++){
           maxRow = Math.max(maxRow, stones[i][0]);
           maxCol  = Math.max(maxCol, stones[i][1]);

       }

       DisjointSet ds = new DisjointSet(maxRow+ maxCol + 1);
        HashMap<Integer, Integer> stoneNodes = new HashMap<>();
        for(int i=0; i<n; i++){
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1] + maxRow + 1;
            ds.unionbySize(nodeRow, nodeCol);
            stoneNodes.put(nodeRow, 1);
            stoneNodes.put(nodeCol, 1);
        }

        int count =0;

        for(Map.Entry<Integer, Integer> entry : stoneNodes.entrySet()){

            if (ds.findUp(entry.getKey()) == entry.getKey()) {
                count++;
            }
        }
return n - count;
    }
}

class DisjointSet{
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    public DisjointSet(int n){

        for(int i=0; i<=n; i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUp(int node){

        if(node == parent.get(node)) return node;

        int ulp = findUp(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionbySize ( int u , int v){
        int ulp_u = findUp(u);
        int ulp_v = findUp(v);

        if(ulp_u == ulp_v) return;

        if(size.get(ulp_u) >= size.get(ulp_v)){
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
        else {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        }
    }
}
