public class Solution {
    public int sumNumbers(TreeNode root) {
        return get_Sum(root, 0) % 1003;
    }

    public static int get_Sum(TreeNode root, int curr_sum){
        // Base case
        if (root==null) return 0;
        if (root.left==null && root.right==null){
            curr_sum = (curr_sum*10)%1003  + root.val;
            return curr_sum%1003;
        }
        
        curr_sum = (curr_sum*10)%1003 + root.val;
        return get_Sum(root.left, curr_sum)%1003 + get_Sum(root.right, curr_sum)%1003;
    }
}