package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueinEachTreeRow {

    // https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/

    public List<Integer> largestValues(TreeNode root) {

        if(root==null){
            return new ArrayList<>();
        }

      List<Integer> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){

            int size = queue.size();

            int maxvalue = Integer.MIN_VALUE;

            for( int i=0 ; i<size; i++){
                TreeNode currentnode = queue.poll();

                if(currentnode.val > maxvalue){
                    maxvalue= currentnode.val;
                }

                if(currentnode.left != null){
                    queue.offer(currentnode.left);
                }

                if(currentnode.right != null){
                    queue.offer(currentnode.right);
                }
            }

            result.add(maxvalue);
        }

        return result;

    }
}
