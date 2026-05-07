// Approach -
// For a node, find the left height & right height
//      1. Maximum path can be: (left height + right height)
//      2. Check if global maximum can be updated
//      3. Return the height of the tree including the node
//      4. Use a static variable since it needs to be shared &
//         update it in main function since every testcase won't reset it on its own

class Solution {
    static int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        getheight(root);
        return diameter;
    }

    int getheight(TreeNode root){
        if (root==null) return 0;

        int lh = getheight(root.left);
        int rh = getheight(root.right);
        diameter = Math.max(diameter, lh+rh);

        return 1 + Math.max(lh, rh);
    }
}
