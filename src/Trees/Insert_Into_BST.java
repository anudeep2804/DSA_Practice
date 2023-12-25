package Trees;

public class Insert_Into_BST {

        public TreeNode insertIntoBST(TreeNode root, int val) {
            if(root==null) return new TreeNode(val);
            if(val<root.val) root.left = insertIntoBST(root.left,val);
            else root.right = insertIntoBST(root.right,val);
            return root;
        }
}
