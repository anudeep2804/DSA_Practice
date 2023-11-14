package Trees;

import java.util.ArrayList;

public class SumRoottoLeafNumbers {

    int totalsum =0;

    public int  sumNumbers(TreeNode root) {

       return helper(root, 0);
    }

    private int helper(TreeNode root, int sum) {

        if(root == null){
            return 0;
        }

        if(root.left ==null && root.right == null){
            totalsum=totalsum+sum*10 + root.val;
        }

        helper(root.left , sum*10+root.val);
        helper(root.right, sum*10+ root.val);

        return totalsum;
    }

}
