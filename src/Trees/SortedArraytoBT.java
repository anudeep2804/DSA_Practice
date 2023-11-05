package Trees;

import java.util.Arrays;

public class SortedArraytoBT {

    public TreeNode sortedArrayToBST(int[] nums) {

        if (nums.length == 0) {
            return null;
        }


        TreeNode root = new TreeNode(nums[nums.length / 2]);

        TreeNode left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, (nums.length / 2)));

        TreeNode right = sortedArrayToBST(Arrays.copyOfRange(nums, (nums.length / 2) + 1, (nums.length)));

        root.left = left;

        root.right = right;

        return root;

    }

}
