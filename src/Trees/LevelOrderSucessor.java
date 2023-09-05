package Trees;

import Trees.TreeNode;

import java.util.Queue;
import java.util.LinkedList;

public class LevelOrderSucessor {

    public int LevelOrderSucessorofNode(TreeNode root, TreeNode node){
        if(root==null){
            return Integer.MIN_VALUE;
        }

        Queue<TreeNode>  treeNodes = new LinkedList<>();
        treeNodes.add(root);
        int sucessornodevalue = 0;
        boolean isrequirednode = false;

        while(!treeNodes.isEmpty()){
            int currentlevelsize = treeNodes.size();
            for(int i=0; i<currentlevelsize; i++){
                TreeNode currentnode = treeNodes.poll();
                if(currentnode == node){
                    isrequirednode = true;
                    break;
                }
                if(currentnode.left != null){
                    treeNodes.offer(currentnode.left);
                }

                if(currentnode.right != null){
                    treeNodes.offer(currentnode.right);
                }
            }

            if(!treeNodes.isEmpty() && isrequirednode){
                sucessornodevalue = treeNodes.poll().val;
                break;
            }
            else if(treeNodes.isEmpty()){
                sucessornodevalue = Integer.MIN_VALUE;
            }
        }

        if (!isrequirednode) {
            return Integer.MIN_VALUE;  // Node was not found
        }

        return sucessornodevalue;
    }


}
