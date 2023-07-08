package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    public static  void levelorder( TreeNode root){

        if(root==null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while(!queue.isEmpty()){
            TreeNode currentnode =  queue.remove();
            if(currentnode==null){
                System.out.println();
                if(queue.isEmpty()){
                    break;
                }
                else{
                    queue.add(null);
                }
            }else{
                System.out.print(currentnode.val);
                if(currentnode.left !=null){
                    queue.add(currentnode.left);
                }
                if(currentnode.right !=null){
                    queue.add(currentnode.right);
                }
            }

        }

    }

}
