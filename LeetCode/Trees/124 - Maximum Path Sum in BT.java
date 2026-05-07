// Approach -
// For a node, compute the maxSum from left subtree & right subtree
//      1. If the left subtree has a -ve maximum sum return 0 (rather not consider it at all)
//      2. If the right subtree has a -ve maximum sum return 0 (rather not consider it at all)
//      3. Check if the global maximum or current (root + leftMax + rightMax) which is greater
//      4. Return the global maxSum

class Solution {
    static int resSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        resSum = Integer.MIN_VALUE;
        getMaxSum(root);
        return resSum;
    }

    int getMaxSum(TreeNode root){
        if (root==null) return 0;

        int leftMax = Math.max(0, getMaxSum(root.left));
        int rightMax = Math.max(0, getMaxSum(root.right));

        // Condition for Maximum path sum
        resSum = Math.max(resSum, root.val+leftMax+rightMax);
        return root.val + Math.max(leftMax, rightMax);
    }
}