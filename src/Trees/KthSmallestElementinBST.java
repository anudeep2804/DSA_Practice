package Trees;

import java.util.ArrayList;

public class KthSmallestElementinBST {

    ArrayList<Integer> arrayList = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {

        inordertraversal(root);

        return arrayList.get(k-1);

    }

    public void inordertraversal (TreeNode root){

        if(root == null){
            return;
        }

        inordertraversal(root.left);

        arrayList.add(root.val);

        inordertraversal(root.right);

    }
}
