package interview.leetcode;

import interview.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryInOrderTraversal {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        if (root != null)
            inorderTraversal(root, values);
        return values;
    }

    public static void inorderTraversal(TreeNode root, List<Integer> values) {
        if (root.left != null) {
            inorderTraversal(root.left, values);
        }
        values.add(root.val);
        if (root.right != null) {
            inorderTraversal(root.right, values);
        }
    }

}
