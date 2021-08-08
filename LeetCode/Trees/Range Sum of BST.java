// Recursive Solution
// Code by @Om
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        if (root==null) return 0;
        else if (root!=null && (low<=root.val) && (root.val <= high)) sum += root.val;
        // Left subtree sum
        sum += rangeSumBST(root.left, low, high);
        // Right subtree sum
        sum += rangeSumBST(root.right, low, high);
        return sum;
    }
}
