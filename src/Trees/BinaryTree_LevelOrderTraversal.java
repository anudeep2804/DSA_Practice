package Trees;


import java.util.*;

public class BinaryTree_LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root){
        if(root==null){
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> result = new ArrayList<>();

        while(!queue.isEmpty()){
            int currentlevel= queue.size();;
            List<Integer> currentlevellist = new ArrayList<>();
            for(int i=0;i<currentlevel;i++){
                TreeNode currentnode= queue.poll();
                if(currentnode.left!=null){
                    queue.offer(currentnode.left);
                }
                if(currentnode.right!=null){
                    queue.add(currentnode.right);
                }

                currentlevellist.add(currentnode.val);

            }

            result.add(currentlevellist);
        }

        return result;

    }
}
