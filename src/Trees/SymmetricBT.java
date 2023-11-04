package Trees;

import com.sun.source.tree.Tree;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;


public class SymmetricBT {

        /*

        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true; // An empty tree is symmetric

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int size = queue.size();
                ArrayList<TreeNode> arrayList = new ArrayList<>();

                for (int i = 0; i < size; i++) {
                    TreeNode currentnode = queue.poll();

                    // Add left and right children (or null if they are absent) to the arrayList
                    arrayList.add(currentnode.left);
                    if (currentnode.left != null) {
                        queue.offer(currentnode.left);
                    }

                    arrayList.add(currentnode.right);
                    if (currentnode.right != null) {
                        queue.offer(currentnode.right);
                    }
                }

                // Check if the current level is a mirror of itself
                if (!ismirror(arrayList)) {
                    return false;
                }
            }

            return true;
        }

        public boolean ismirror(ArrayList<TreeNode> arrayList) {
            int start = 0;
            int end = arrayList.size() - 1;

            while (start < end) {
                TreeNode startNode = arrayList.get(start);
                TreeNode endNode = arrayList.get(end);

                if (startNode == null && endNode == null) {
                    start++;
                    end--;
                    continue;
                }

                if (startNode == null || endNode == null) return false;
                if (startNode.val != endNode.val) return false;

                start++;
                end--;
            }

            return true;
        }
        */

        public boolean isSymmetric(TreeNode root) {

            if(root==null) return false;

            Queue<TreeNode> queue = new LinkedList<>();

            queue.add(root.left);
            queue.add(root.right);

            while(!queue.isEmpty()){
                TreeNode left = queue.poll();
                TreeNode right = queue.poll();

                if(left==null&&right==null){
                    continue;
                }

                if(left==null || right==null){
                    return  false;
                }

                if(left.val != right.val){
                    return  false;
                }

                queue.add(left.left);
                queue.add(right.right);
                queue.add(left.right);
                queue.add(right.left);
            }

            return true;
        }
    }



