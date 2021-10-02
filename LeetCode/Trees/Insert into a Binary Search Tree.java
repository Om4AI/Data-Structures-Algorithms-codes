// Code by @Om
class Solution {
    
    TreeNode high_root;
    public TreeNode insertIntoBST(TreeNode root, int val) {

//         No nodes in tree
        if (root==null) return new TreeNode(val);
        
        // Function to change the tree without returning anything
        insert_node(root, val);
        return root;
    }

    public void insert_node(TreeNode root, int val){
        TreeNode node = new TreeNode(val);  // Create new node

        // Node cases where the value can be directly attached
        if (val<root.val && root.left==null) root.left = node;
        else if (val>root.val && root.right==null) root.right = node;

        // Further exploration - Recursive calls
        else if (val<root.val && root.left!=null) insert_node(root.left, val);
        else if (val>root.val && root.right!=null) insert_node(root.right, val);
    }
}
