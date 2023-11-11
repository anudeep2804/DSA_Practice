package Trees;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ConstructBTfromInOrderPreOrder {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder.length==0){
            return  null;
        }

        TreeNode rootnode = new TreeNode(preorder[0]);

        int index=0;

        for(int i=0; i<inorder.length;i++){
            if(inorder[i]==preorder[0]) index = i;
        }

        rootnode.left = buildTree(Arrays.copyOfRange(preorder, 1, index+1) ,
                Arrays.copyOfRange(inorder, 0 , index));

        rootnode.right = buildTree(Arrays.copyOfRange(preorder, index+1, preorder.length)
        , Arrays.copyOfRange(inorder, index+1, inorder.length));

        return rootnode;

    }

}
