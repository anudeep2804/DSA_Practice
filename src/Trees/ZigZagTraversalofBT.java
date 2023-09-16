package Trees;
import com.sun.source.tree.Tree;

import java.util.*;

public class ZigZagTraversalofBT {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();


        if(root==null){
            return result;
        }

        deque.addFirst(root);
        int counter=1;

        while(!deque.isEmpty()){
            int currentqueuesize=deque.size();
            List<Integer> templist = new ArrayList<>();
            TreeNode currentnode;

            if(counter %2 !=0){
                for(int i=0;i<currentqueuesize;i++){
                    currentnode=deque.removeLast();
                    templist.add(currentnode.val);

                    if(currentnode.left!=null){
                        deque.offer(currentnode.left);
                    }

                    if(currentnode.right!=null){
                        deque.addFirst(currentnode.right);
                    }
                }
            }
            else {

                for (int i = 0; i < currentqueuesize; i++) {
                    currentnode = deque.removeFirst();
                    templist.add(currentnode.val);

                    if (currentnode.right != null) {
                        deque.addLast(currentnode.right);
                    }

                    if (currentnode.left != null) {
                        deque.addLast(currentnode.left);
                    }
                }

            }
            counter++;

            result.add(templist);
        }

        return result;
    }
}
