

/*

Initial approach - got issues with null pointer exceptions

Handled them in below code , while retaining the logic

public class FlattenBTtoLL {

    public void flatten(TreeNode root) {

       flattenBT(root);

    }

    public TreeNode flattenBT(TreeNode root){

        if(root==null){
            return root;
        }

        TreeNode temp;

        temp=root.right;
        root.right=flattenBT(root.left);
        root.left=null;
       TreeNode temp1= findlast(root.right);
       temp1.right=flattenBT(temp);

        return root;
    }

    public TreeNode findlast(TreeNode root){

        while(root!=null && root.right!=null){
            root=root.right;
        }

        return root;
    }
}

*/


package Trees;

import com.sun.source.tree.Tree;

public class FlattenBTtoLL {

    public void flatten(TreeNode root) {
       flattenBT(root);
    }

    public TreeNode flattenBT(TreeNode root){
        if(root==null){
            return root;
        }

        TreeNode temp = root.right;
        root.right = flattenBT(root.left);
        root.left = null;

        if (root.right != null) {
            TreeNode temp1 = findlast(root.right);
            temp1.right = flattenBT(temp);
        } else {
           root.right = flattenBT(temp);
        }

        return root;
    }

    public TreeNode findlast(TreeNode root){
        while(root != null && root.right != null){
            root = root.right;
        }
        return root;
    }
}


