class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // Null node
        if (root == null) return false;
        // Only single node
        if (root.left == null && root.right==null && root.val == targetSum) return true;

        // General case
        return (hasPathSum(root.left, targetSum-root.val) || hasPathSum(root.right, targetSum-root.val));
    }
}
