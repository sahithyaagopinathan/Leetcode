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
    private Map<String, List<TreeNode>> memo = new HashMap<>();
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return buildTrees(1, n);
    }
    private List<TreeNode> buildTrees(int start, int end) {
        List<TreeNode> trees = new ArrayList<>();
        if (start > end) {
            trees.add(null);
            return trees;
        }
        String key = start + "-" + end;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSubtrees = buildTrees(start, i - 1);
            List<TreeNode> rightSubtrees = buildTrees(i + 1, end);
            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    trees.add(root);
                }
            }
        }
        memo.put(key, trees);
        return trees;
    }
}