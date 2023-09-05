package Trees;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AvgofLevels_BT {

    public List<Double> averageOfLevels(TreeNode root) {

        if(root ==null){
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Double> result = new ArrayList<>();

        while(!queue.isEmpty()){
            double avgofcurrentlevel=0.0;
            double sumofcurrentlevel=0.0;
            TreeNode currentnode;
            int currentqueuesize= queue.size();;
            for(int i=0;i<currentqueuesize;i++){
                currentnode=queue.poll();
                sumofcurrentlevel=sumofcurrentlevel+currentnode.val;

                if(currentnode.left!=null){
                    queue.offer(currentnode.left);
                }

                if(currentnode.right!=null){
                    queue.offer(currentnode.right);
                }
            }
            avgofcurrentlevel=sumofcurrentlevel/currentqueuesize;
            result.add(avgofcurrentlevel);
        }

        return result;
    }
}
