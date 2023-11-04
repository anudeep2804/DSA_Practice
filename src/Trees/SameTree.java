package Trees;

import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        Queue<TreeNode> queue = new LinkedList<>();

        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        queue.offer(p);
        queue.offer(q);

        while (!queue.isEmpty()) {
            TreeNode leftTree = queue.poll();
            TreeNode rightTree = queue.poll();

            // Check left children
            if (leftTree.left != null && rightTree.left != null) {
                if (leftTree.left.val != rightTree.left.val) {
                    return false;
                }
                queue.offer(leftTree.left);
                queue.offer(rightTree.left);
            } else if (leftTree.left != null || rightTree.left != null) {
                return false;
            }

            // Check right children
            if (leftTree.right != null && rightTree.right != null) {
                if (leftTree.right.val != rightTree.right.val) {
                    return false;
                }
                queue.offer(leftTree.right);
                queue.offer(rightTree.right);
            } else if (leftTree.right != null || rightTree.right != null) {
                return false;
            }
        }

        return true;
    }
}
