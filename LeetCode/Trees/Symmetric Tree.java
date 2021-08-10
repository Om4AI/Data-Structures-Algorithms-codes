// Java Recursive Method
class Solution {
    public static boolean symmetry(TreeNode left, TreeNode right){
        if (left==null && right==null) return true;
        else if (left==null || right==null) return false;
        else if (left.val!=right.val) return false;
        else{
            return symmetry(left.left, right.right) && symmetry(left.right, right.left);
        }
    }
    
    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        return symmetry(root.left, root.right);
    }
}
