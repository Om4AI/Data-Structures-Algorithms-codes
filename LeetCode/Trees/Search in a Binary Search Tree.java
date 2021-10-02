// Code by @Om
class Solution {
    TreeNode res;
    public TreeNode searchBST(TreeNode root, int val) {
//         Blank tree case
        if (root==null) return null;
        
        if (val==root.val) return root;
        else if (val<root.val) return searchBST(root.left, val);
        else if (val>root.val) return searchBST(root.right, val);
        
        return null;
    }
}
