// Code by @Om
class Solution {
    int max = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root==null) return 0;
        else{
            int lh = getmaxheight(root.left);
            int rh = getmaxheight(root.right);
            if (lh+rh > max) max = lh+rh;
            diameterOfBinaryTree(root.left);
            diameterOfBinaryTree(root.right);
        }
        return max;
    }

    public int getmaxheight(TreeNode root){
        if (root==null) return 0;
        else return (1 + Math.max(getmaxheight(root.left), getmaxheight(root.right)));
    }
}
