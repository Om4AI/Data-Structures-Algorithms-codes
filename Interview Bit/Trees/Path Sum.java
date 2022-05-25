public class Solution {
    public int hasPathSum(TreeNode root, int target){
        // Cases - Single node and no nodes
        if(root==null) return 0;
        if(root.left==null && root.right==null && root.val==target) return 1;

        // Check if the sum is present in the left subtree or in right subtree
        if(hasPathSum(root.left,target-root.val)==1 || hasPathSum(root.right,target-root.val)==1) return 1;
        return 0;
    }
}
