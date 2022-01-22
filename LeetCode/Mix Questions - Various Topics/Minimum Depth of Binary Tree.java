class Solution {
    public int minDepth(TreeNode root) {
//         Left Node
        if (root==null) return 0;
        
//         Any other node
        int leftdepth = minDepth(root.left);  //Depth of left subtree
        int rightdepth = minDepth(root.right);  //Depth of right subtree
        
        if (leftdepth==0) return 1+rightdepth;
        else if (rightdepth==0) return 1+leftdepth;
        else return 1+Math.min(leftdepth, rightdepth);
    }
}
