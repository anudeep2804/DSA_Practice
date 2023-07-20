package Trees;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InOrderIterative {

    public List<Integer> inordertraversal(TreeNode root){

        if(root==null){
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (true) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                if (stack.isEmpty()) break;
                root = stack.peek();
                result.add(root.val);
                stack.pop();
                root = root.right;
            }
        }
        return result;

    }
}
