// Code by @Om
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root==null) return null;
        else if (root.val == val) return root;
        else if (val>root.val) {
            root = searchBST(root.right, val);
        }
        else if (val < root.val) {
            root = searchBST(root.left, val);
        }
        return root;
    }
}
