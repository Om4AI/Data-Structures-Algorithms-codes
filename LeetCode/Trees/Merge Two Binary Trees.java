// Code by @Om
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode merged = new TreeNode();
        // Single node cases
        if (root1==null && root2==null) return null;
        else if (root1==null) return root2;
        else if (root2==null) return root1;
        // General case
        else{
            merged.val = root1.val + root2.val;
        }
        merged.left = mergeTrees(root1.left, root2.left);
        merged.right = mergeTrees(root1.right, root2.right);
        return merged;
    }
}
