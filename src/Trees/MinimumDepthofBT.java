package Trees;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MinimumDepthofBT {

    public int minDepth(TreeNode root){
      if(root==null){
          return 0;
      }

      Queue<TreeNode> queue = new LinkedList<>();
      int level=1;

        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
            TreeNode currentnode = queue.poll();

            if(currentnode.left==null && currentnode.right == null){
                return level;
            }

            if(currentnode.left!=null){
                queue.add(currentnode.left);
            }
            if(currentnode.right!=null){
                queue.add(currentnode.right);
            }



        }
            level++;
        }

        return level;
    }
}
