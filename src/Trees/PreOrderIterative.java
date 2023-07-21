package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderIterative {

    public List<Integer> preordertraversal(TreeNode root) {

        if(root==null){
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode currentnode = root;
        stack.push(currentnode);

        while(!stack.isEmpty()){

            currentnode=stack.peek();
            result.add(currentnode.val);
            stack.pop();

            if(currentnode.left!=null){
                stack.push(currentnode.left);
            }
            if(currentnode.right!=null){
                stack.push(currentnode.right);
            }
        }
            return result;
        }
}
