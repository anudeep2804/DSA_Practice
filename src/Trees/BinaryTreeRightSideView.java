package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root==null){
            return ans;
        }

        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode currentnode = queue.poll();

                if(i == size-1){
                    ans.add(currentnode.val);
                }

                if(currentnode.left!=null){
                    queue.offer(currentnode.left);
                }

                if(currentnode.right!=null){
                    queue.offer(currentnode.right);
                }
            }
        }

        return ans;
    }

}
