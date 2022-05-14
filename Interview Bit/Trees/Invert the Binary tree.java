class Solution {
    public TreeNode invertTree(TreeNode root){
        // Base condition
        if (root==null) return null;
        
        // Simple swapping
        else{
            TreeNode t = new TreeNode(0);
            root.left = invertTree(root.left);
            root.right = invertTree(root.right);
            t = root.left;
            root.left = root.right;
            root.right = t;
            return root;
        }
    }
}