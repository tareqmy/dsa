package interview.leetcode;

/**
 * Created by tareqmy on 24/7/20.
 */
public class SortedArray2BinaryTree {

//    Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
//
//    For this problem, a height-balanced binary tree is defined as a binary tree
//    in which the depth of the two subtrees of every node never differ by more than 1.

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    //NOTE: without help... but needed thought.. which might be easier with pen and paper.
    public TreeNode sortedArrayToBST(int[] nums, int i, int j) {
        if (i > j) {
            return null;
        }
        if (i == j) {
            return new TreeNode(nums[i]);
        }
        int k = (i + j) / 2;
        TreeNode node = new TreeNode(nums[k]);
        node.left = sortedArrayToBST(nums, i, k - 1);
        node.right = sortedArrayToBST(nums, k + 1, j);
        return node;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
