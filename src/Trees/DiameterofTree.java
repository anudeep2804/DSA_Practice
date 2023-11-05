package Trees;

import com.sun.source.tree.Tree;

public class DiameterofTree {
    int diam = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return diam;
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;  // The depth of a null node is 0.
        }

        int leftDepth = depth(node.left); // Compute the depth of the left subtree.
        int rightDepth = depth(node.right); // Compute the depth of the right subtree.

        // Update the diameter where node is the highest node in the path.
        // The diameter is the number of edges between the left and right deepest nodes, which does not include the current node itself.
        diam = Math.max(diam, leftDepth + rightDepth);

        // Return the depth to the parent node: max depth of the subtrees + 1 for the current node's edge.
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
