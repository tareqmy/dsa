package interview.leetcode;

import interview.TreeNode;

/**
 * Created by tareqmy on 19/7/20.
 */
public class MaxDepthBinaryTree {

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return depth(root, 1);
    }

    //NOTE: FAILED a few times on submission
    private static int depth(TreeNode node, int depth) {
        if (node == null || (node.left == null && node.right == null)) {
            return depth;
        }
        depth++;
        System.out.println("node.val = " + node.val + " depth=" + depth);
        int leftDepth = 0;
        int rightDepth = 0;
        if (node.left != null)
            leftDepth = depth(node.left, depth);
        if (node.right != null)
            rightDepth = depth(node.right, depth);
        return Math.max(leftDepth, rightDepth);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(20, new TreeNode(15), new TreeNode(7, new TreeNode(15), new TreeNode(7))), new TreeNode(9));
        System.out.println("maxDepth = " + maxDepth(root));
    }


    //taken from leetcode
    public int maxDepthLeetCode(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

}
