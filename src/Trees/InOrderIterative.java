package Trees;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InOrderIterative {

    public List<Integer> inorderTraversal(TreeNode root) {

        if(root==null){
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode currentnode = root;


        while(!stack.isEmpty() || currentnode !=null ){

            // keep moving to the left
            while(currentnode!=null){
                stack.add(currentnode);
                currentnode=currentnode.left;
            } // by the end of the loop currentnode will be null

            currentnode=stack.pop(); // reassign currentnode to last processed node
            result.add(currentnode.val); // add its value

            currentnode=currentnode.right; // move to right
        }


        return result;

    }
}
