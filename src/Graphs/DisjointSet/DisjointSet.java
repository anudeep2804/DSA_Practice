package Graphs.DisjointSet;

/* Notes
Disjoint Set Union (DSU) / Union-Find Data Structure

1. Union by Rank:
   - Uses the height (rank) of trees to determine which tree becomes the parent during a union operation
   - Always attaches the shorter tree to the root of the taller tree
   - Helps keep the tree balanced and reduces the overall height

2. Union by Size:
   - Uses the size (number of nodes) of trees to determine which tree becomes the parent during a union operation
   - Always attaches the smaller tree to the root of the larger tree
   - Helps distribute nodes more evenly and can lead to better performance in some cases

Pseudocode for Union by Rank:
function find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])  // Path compression
    return parent[x]

function union(x, y):
    rootX = find(x)
    rootY = find(y)
    if rootX != rootY:
        if rank[rootX] < rank[rootY]:
            parent[rootX] = rootY
        else if rank[rootX] > rank[rootY]:
            parent[rootY] = rootX
        else:
            parent[rootY] = rootX
            rank[rootX]++

Pseudocode for Union by Size:
function find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])  // Path compression
    return parent[x]

function union(x, y):
    rootX = find(x)
    rootY = find(y)
    if rootX != rootY:
        if size[rootX] < size[rootY]:
            parent[rootX] = rootY
            size[rootY] += size[rootX]
        else:
            parent[rootY] = rootX
            size[rootX] += size[rootY]

Time Complexity:
- Find operation: O(α(n)) amortized, where α(n) is the inverse Ackermann function
- Union operation: O(α(n)) amortized
- Make-Set operation: O(1)

Note: α(n) grows extremely slowly and is effectively constant for all practical values of n.
The amortized time complexity is nearly constant due to path compression optimization.

Space Complexity:
- O(n) where n is the number of elements in the set

Key Differences:
- Union by Rank uses tree height for decision-making, while Union by Size uses the number of nodes
- Both achieve similar performance in practice, but Union by Size can be slightly more intuitive
- Union by Rank guarantees a logarithmic height bound, while Union by Size achieves it on average
*/


import java.util.ArrayList;
import java.util.List;

public class DisjointSet {

    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public  DisjointSet(int n){
        for(int i=0; i<=n; i++){
            parent.add(i);
            rank.add(0);
            size.add(1);
        }
    }

    public int findUltimateParent(int node){
        if(node == parent.get(node)){
            return node;
        }
        int ulp = findUltimateParent(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

   public  void unionByRank(int u, int v){
        int ulp_u = findUltimateParent(u);
        int ulp_v = findUltimateParent(v);

        if(ulp_u == ulp_v) return;

        if(rank.get(ulp_u) > rank.get(ulp_v)){
            parent.set(ulp_v, ulp_u);
        } else if(rank.get(ulp_u) < rank.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
        } else {
            parent.set(ulp_v, ulp_u);
            rank.set(ulp_u, rank.get(ulp_u) + 1); // Increment rank only if ranks are equal
        }
    }


  public void unionBySize(int u, int v){
        int ulp_u = findUltimateParent(u);
        int ulp_v = findUltimateParent(v);

        if (ulp_u == ulp_v) {
            return;
        }

        // Perform the union by size
        if (size.get(ulp_u) >= size.get(ulp_v)) {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        } else {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        }
    }


}

class Main {
    public static void main (String[] args) {
        DisjointSet ds = new DisjointSet(7);
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);

        // if 3 and 7 same or not
        if (ds.findUltimateParent(3) == ds.findUltimateParent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");

        ds.unionByRank(3, 7);
        if (ds.findUltimateParent(3) == ds.findUltimateParent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");
    }
}


