import java.util.*;
class Solution {
    public int sumNumbers(TreeNode root) {
        return get_Sum(root, 0);
    }


    public static int get_Sum(TreeNode root, int curr_sum){
        // Base case
        if (root==null) return 0;
        if (root.left==null && root.right==null){
            curr_sum = curr_sum*10 + root.val;
            return curr_sum;
        }
        
        curr_sum = curr_sum*10 + root.val;
        return get_Sum(root.left, curr_sum) + get_Sum(root.right, curr_sum);
    }
}