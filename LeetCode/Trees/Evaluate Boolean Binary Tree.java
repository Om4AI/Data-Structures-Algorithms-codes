import java.util.*;

class Solution {
    public boolean evaluateTree(TreeNode root) {
        // Base conditions
        if(root.val==0) return false;
        else if(root.val==1) return true;

        // General case
        return (root.val==2)? (evaluateTree(root.left)||evaluateTree(root.right)) : (evaluateTree(root.left)&&evaluateTree(root.right));
    }
}