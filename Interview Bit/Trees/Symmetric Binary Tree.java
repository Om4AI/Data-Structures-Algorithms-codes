public class Solution {
    public int isSymmetric(TreeNode root){
        if(root==null) return 1;

        return (symmetry(root.left,root.right))? 1:0;
    }

    public static boolean symmetry(TreeNode left, TreeNode right){
        if(left==null && right==null) return true;
        if(left==null || right==null) return false;
        if(left.val!=right.val) return false;
        else{
            return (symmetry(left.left,right.right) && symmetry(left.right, right.left));
        }
    }
}
