// Interview Bit accepts ths weird 0/1 output instead of boolean values

public class Solution {
    public int isSameTree(TreeNode a, TreeNode b) {
        // Base cases
        if(a==null && b==null) return 1;
        if(a==null || b==null) return 0;

        // Actual case
        if(a.val==b.val && isSameTree(a.left,b.left)==1 && isSameTree(a.right,b.right)==1) return 1;
        return 0;
    }
}
