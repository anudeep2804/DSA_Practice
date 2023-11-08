package Trees;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class ValidateBST {

    // inorder traversal of BST returns strictly increasing sequence

    private long minval = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {

        if(root ==null){
            return true;
        }

        if(!isValidBST(root.left)) return false;

        if(minval>= root.val) return false;

            minval = root.val;;

            if(!isValidBST(root.right)) return  false;

            return true;
    }


}

