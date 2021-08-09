// Code by @Om
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root==null) return null;
        else{
            TreeNode t = new TreeNode();
            root.left = invertTree(root.left);
            root.right = invertTree(root.right);
            t = root.left;
            root.left = root.right;
            root.right = t;
            return root;
        }
    }
}
