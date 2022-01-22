class Solution {
    public int maxDepth(TreeNode root) {
//         Leaf Node 
        if (root==null) return 0;
        
//         For any other node in the Tree
        int leftdepth = maxDepth(root.left);  //Depth of left subtree
        int rightdepth = maxDepth(root.right);  //Depth of right subtree
        
//         Height from any other node
        return 1+Math.max(leftdepth, rightdepth);
    }
}
