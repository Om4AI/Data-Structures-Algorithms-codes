// Code by @Om
class Solution {
    // Compute & add the tilt are each node
    public int findTilt(TreeNode root) {
        int sum = 0;
        if (root==null) return 0;

        // Get the absolute difference for single root
        else{
            int left = get_sum(root.left);
            int right = get_sum(root.right);
            sum += Math.abs(left-right);
        }
        return (sum+findTilt(root.left)+findTilt(root.right));
    }

    // Get the sum of a subtree
    public int get_sum(TreeNode root){
        int s = 0;
        if (root==null) return 0;
        else{
            s+=root.val;
            s = s+get_sum(root.left)+get_sum(root.right);
        }
        return s;
    }
}


// Optimized Code

// Code by @Om
class Solution {
    int res = 0;
    public int findTilt(TreeNode root) {
        get_sum(root);
        return res;
    }

    // Get the sum of a subtree
    public int get_sum(TreeNode root){
        if (root==null) return 0;
        
        int left = get_sum(root.left);
        int right = get_sum(root.right);

        // Store the tilt in the result 
        res+= Math.abs(left-right);
        // Return the sum of the subtree 
        return left+right+root.val;
    }
}
