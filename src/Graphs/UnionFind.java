package Graphs;

//https://leetcode.com/problems/number-of-operations-to-make-network-connected/

import java.util.Arrays;

public class UnionFind {

    public int makeConnected(int n, int[][] connections) {

        int given_edges = connections.length;

        int mst_size = 0;

        int[] parent = new int[n];

        for(int i=0; i<n; i++){
            parent[i]=i;
        }

        int[] size = new int[n];

        Arrays.fill(size, 1);

        for(int[] current_edge : connections){
            int current_src = current_edge[0];
            int current_dest = current_edge[1];

            if(findUltimateParent(current_src, parent) != findUltimateParent(current_dest, parent)){
                mst_size++;
                unionBySize(current_src,current_dest, parent, size);
            }
        }

        if(given_edges < n - 1){
            return -1;
        }

        int components = 0;
        for(int i = 0; i < n; i++){
            if(findUltimateParent(i, parent) == i){
                components++;
            }
        }

        return components - 1;

    }

    public int findUltimateParent(int n , int[] parent){

        if(parent[n]==n){
            return n;
        }
        int ulp = parent[n];

        return findUltimateParent(ulp, parent);
    }

    public void unionBySize(int u, int v , int[] parent, int[] size){

        int ulp_u = findUltimateParent(u , parent);
        int ulp_v = findUltimateParent(v , parent);

        if(ulp_u != ulp_v){

            if(size[ulp_u] >= size[ulp_v]){
                parent[ulp_v] = ulp_u;
                size[ulp_u] = size[ulp_u]+size[ulp_v];
            }
            else {
                parent[ulp_u] = ulp_v;
                size[ulp_v]= size[ulp_v] + size[ulp_u];
            }
        }
    }
}
