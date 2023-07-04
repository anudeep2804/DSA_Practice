package ArraysandHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Prime_Pairs_with_TargetSum {
    public List<List<Integer>> findPrimePairs(int n) {

        HashSet<Integer> hashSet = new HashSet<>();

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i < n; i++) {
             List<Integer> templist = new ArrayList<>();
            if (i > 3 && (i % 2 == 0 || i % 3 == 0 )) {
                continue;
            }

            if (isprime(i) == true && isprime(n - i) == true && hashSet.contains(i) !=true) {
                if(i==n-i){
                    hashSet.add(i);
                }
                else {
                    hashSet.add(i);
                    hashSet.add(n-i);
                }
                templist.add(i);
                templist.add(n - i);
                 ans.add(templist);

            }

        }


        return ans;
    }

    public boolean isprime(int n) {

        if ( n == 2 || n==3 || n==5 || n==7) {
            return true;
        }

        if(n==1){
            return false;
        }

          if (n % 2 == 0 || n % 3 == 0)
                     return false;
        for (int i = 5; i <= Math.sqrt(n); i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;
    }

    public static void main(String[] args) {
        Prime_Pairs_with_TargetSum primePairs = new Prime_Pairs_with_TargetSum();
        int n = 2; // choose a target number}
        List<List<Integer>> pairs = primePairs.findPrimePairs(n);
        for (List<Integer> pair : pairs) {
                System.out.println(pair.toString());
    }       }
}