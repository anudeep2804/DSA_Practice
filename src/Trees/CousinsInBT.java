package Trees;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

    public class CousinsInBT {

        /*

        public boolean isCousins(TreeNode root, int x, int y) {
            boolean ans = false;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            HashSet<Integer> hashSet = new HashSet<>();
            hashSet.add(x);
            hashSet.add(y);

            while (!queue.isEmpty()) {
                int size = queue.size();
                boolean valuesatsamelvl = false;
                HashSet<Integer> hashSet1 = new HashSet<>();
                hashSet1.add(x);
                hashSet1.add(y);

                for (int i = 0; i < size; i++) {
                    TreeNode currentnode = queue.poll();
                    if (hashSet1.contains(currentnode.val)) {
                        hashSet1.remove(currentnode.val);
                    }

                    if (currentnode.left != null) {
                        queue.offer(currentnode.left);
                    }

                    if (currentnode.right != null) {
                        queue.offer(currentnode.right);
                    }

                    if (currentnode.left != null && currentnode.right != null) {
                        if (hashSet.contains(currentnode.left.val) && hashSet.contains(currentnode.right.val)) {
                            valuesatsamelvl = true;

                        }
                    }
                }

                if(valuesatsamelvl==true){
                    ans=false;
                    break;
                }


                if (hashSet1.isEmpty() && !valuesatsamelvl) {
                    ans = true;

                }
            }
            return ans;
        }

         */

        public boolean isCousins(TreeNode root, int x, int y) {
            if (root == null) return false;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int size = queue.size();
                boolean isXFound = false;
                boolean isYFound = false;

                for (int i = 0; i < size; i++) {
                    TreeNode current = queue.poll();

                    // Check if the current node is x or y and mark them as found.
                    if (current.val == x) isXFound = true;
                    if (current.val == y) isYFound = true;

                    // Check if x and y are siblings (have the same parent), if so, return false.
                    if (current.left != null && current.right != null) {
                        if ((current.left.val == x && current.right.val == y) ||
                                (current.left.val == y && current.right.val == x)) {
                            return false;
                        }
                    }

                    // Add the children to the queue for the next level.
                    if (current.left != null) queue.offer(current.left);
                    if (current.right != null) queue.offer(current.right);
                }

                // If both x and y are found at the same level, return true.
                if (isXFound && isYFound) return true;

                // If one of x or y is found at the current level, return false as they are not at the same level.
                if (isXFound || isYFound) return false;
            }

            // If neither x nor y are found, return false.
            return false;
        }

    }


