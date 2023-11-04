package Trees;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

    public class CousinsInBT {

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

    }


