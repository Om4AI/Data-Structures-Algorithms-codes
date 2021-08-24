// Code by @Om
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if (root==null) return true;
        else{
            // Initializing the value of root to check sub-trees
            return check_children(root, root.val);
        }
    }

    // Check the lower sub-trees with the initial value of root
    public boolean check_children(TreeNode root, int val){
        if (root==null) return true;
        else if (root.val != val)return false;
        else if (check_children(root.left, val) && check_children(root.right, val)) return true;
        else{
            return false;
        }
    }
}
