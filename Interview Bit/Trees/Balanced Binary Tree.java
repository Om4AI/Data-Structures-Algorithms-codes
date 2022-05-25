public class Solution {
    public int isBalanced(TreeNode root){
        if(root==null) return 1;

        if(isBalanced(root.left)==1 && isBalanced(root.right)==1){
            if(Math.abs(getMaxHeight(root.left)-getMaxHeight(root.right))<=1) return 1;
        }
        return 0;
    }

    public static int getMaxHeight(TreeNode root){
        if(root==null) return 0;

        return Math.max(1+getMaxHeight(root.right), 1+getMaxHeight(root.left));
    }
}
