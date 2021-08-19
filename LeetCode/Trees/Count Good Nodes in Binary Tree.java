// Recursive solution
class Solution {
    public int goodNodes(TreeNode root) {
        return goodNodes(root, Integer.MIN_VALUE);
    }
    
    public int goodNodes(TreeNode root, int max){
        if (root==null) return 0;
        int res = root.val>=max? 1:0;
        res+=goodNodes(root.left, Math.max(root.val, max));
        res+=goodNodes(root.right, Math.max(root.val, max));
        return res;
    }
}
