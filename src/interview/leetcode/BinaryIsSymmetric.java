package interview.leetcode;

import interview.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by tareqmy on 24/7/20.
 */
public class BinaryIsSymmetric {

//    Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
//
//    For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    //NOTE: done after checking leetcode solution
    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t2.left, t1.right);
    }

    public boolean isSymmetricI(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            queue.offer(t1.left);
            queue.offer(t2.right);
            queue.offer(t2.left);
            queue.offer(t1.right);
        }

        return true;
    }
}
