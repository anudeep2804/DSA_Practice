package Trees;

import com.sun.source.tree.Tree;

import java.util.*;

public class BT_LVL_Traversal_II {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<List<Integer>> stack = new ArrayDeque<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null) {
            return result;
        }

        queue.offer(root);

        while(!queue.isEmpty()) {
            int currentsize = queue.size();
            List<Integer> templist = new ArrayList<>();

            // Process nodes of the current level
            for(int i = 0; i < currentsize; i++) {
                TreeNode currentnode = queue.poll();
                templist.add(currentnode.val);


                if(currentnode.left != null) {
                    queue.add(currentnode.left);
                }
                if(currentnode.right != null) {
                    queue.add(currentnode.right);
                }
            }

            // Instead of deque, using a stack to store lists for each level
            stack.push(templist);
        }

        // Pop lists from the stack and add to the result
        while(!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }
}
