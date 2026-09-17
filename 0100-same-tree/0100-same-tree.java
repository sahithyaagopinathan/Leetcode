/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Both nodes are null -> structurally identical at this branch
        if (p == null && q == null) {
            return true;
        }
                                            
        // One node is null while the other is not -> structurally different
        if (p == null || q == null) {
            return false;
        }
                                                                          // Node values do not match
        if (p.val != q.val) {
            return false;
        }
                                                                          // Recursively check left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}