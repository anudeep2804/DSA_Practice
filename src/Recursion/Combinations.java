package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

// https://leetcode.com/problems/combinations/description/
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {

         backtrack(1 , new ArrayList<Integer>() , n ,k);

        return result;

    }

    private  void backtrack(int i, ArrayList<Integer> templist , int n, int k) {

        int size = templist.size();
        if (size == k) {
            List<Integer> temp = new ArrayList<>(templist);
            result.add(temp);
            return;
        } else if (size > k || i > n) {
            return;
        }

        for (int j = i; j <= n; j++) {

            templist.add(j);

            backtrack(j + 1, templist, n, k);

            templist.remove(templist.size() - 1);

        }
    }

}
