package Trees;

public class GoodNodesinBT {

    int counter =0;
    public int goodNodes(TreeNode root) {

        if(root==null){
            return  0;
        }

        counter++;

        helper(root, root.val);

        return counter;

    }

    private void helper(TreeNode root, int val) {

        if(root==null){
            return;
        }

        if(root.left!=null && root.left.val>= val){
            counter++;
            helper(root.left, root.left.val);
        }

        else{
            helper(root.left,val);
        }

        if(root.right!=null && root.right.val>= val){
            counter++;
            helper(root.right, root.right.val);
        }

        else{

            helper(root.right,val);
        }
    }
}
