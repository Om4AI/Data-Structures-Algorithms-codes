// Code by @Om: 0ms
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root==null) return 0;
        if (root.left==null && root.right==null) return 0;

        // Left child
        if (root.left!=null){
            // Check for leaf
            if (root.left.left==null && root.left.right==null){
                sum += root.left.val;
            }else{
                sum += sumOfLeftLeaves(root.left);
            }
        }

        if (root.right!=null){
            // Check for leaf
            if (root.right.left==null && root.right.right==null){
                sum+= 0;
            }else{
                sum += sumOfLeftLeaves(root.right);
            }
        }
        return sum;
    }
}
