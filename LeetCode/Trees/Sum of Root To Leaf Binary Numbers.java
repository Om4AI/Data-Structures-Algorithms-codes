class Solution {
    public int sumRootToLeaf(TreeNode root) {
        // Do a depth first search to get all nodes
        return depth_fs(root, 0);
    }

    public int depth_fs(TreeNode root, int val){
        if (root==null) return 0;

        // 2* value + current.val will serve like adding 
        // decimal to binary addition & again convert to binary
        val = 2*val + root.val;
        // Return the result for recursive usage
        return root.left==root.right ? val: (depth_fs(root.left, val) + depth_fs(root.right, val));
    }
}
