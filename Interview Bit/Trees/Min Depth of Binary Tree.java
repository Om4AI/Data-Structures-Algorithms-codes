public class Solution {
    public int minDepth(TreeNode root){
        // Base case
        if(root==null) return 0;

        // Cases with both children & only left/right child 
        if(root.left!=null && root.right!=null){
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }else if(root.left!=null) return 1+minDepth(root.left);
        else return 1+minDepth(root.right);
    }
}
