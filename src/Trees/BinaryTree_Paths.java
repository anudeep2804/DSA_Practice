package Trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree_Paths {

    List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {


        helper(root, new StringBuilder());
        return result;

    }

    private void helper(TreeNode root, StringBuilder sb) {

        if (root == null) return;

        if (root.left == null && root.right == null) {
            sb.append(root.val);
            String str = sb.toString();
            result.add(str);
        }

        sb.append(root.val);

        helper(root.left, new StringBuilder( sb + "->"));
        helper(root.right, new StringBuilder( sb + "->"));

    }
}
