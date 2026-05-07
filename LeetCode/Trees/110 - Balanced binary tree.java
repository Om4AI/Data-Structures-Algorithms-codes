import java.util.*;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// <---------------------- Brute Force approach ---------------------->
// class Solution {
//     public int getHeight(TreeNode node){
//         if (node==null) return 0;

//         int lh = getHeight(node.left);
//         int rh = getHeight(node.right);
//         return 1 + Math.max(lh, rh);
//     }

//     public boolean isBalanced(TreeNode root){
//         if (root==null) return true;

//         int lh = getHeight(root.left);
//         int rh = getHeight(root.right);

//         if (Math.abs(rh-lh)>1) return false;

//         Boolean left = isBalanced(root.left);
//         Boolean right = isBalanced(root.right);
//         return left && right;
//     }
// }


// <---------------------- Optimized approach ---------------------->
// For a node we go to left & right and find heights
//      1. If the difference in heights is >1: Return -1
//      2. Else return the height: 1 + max(left_height, right_height)
class Solution {
    public boolean isBalanced(TreeNode root){
        return dfsHeight(root) != -1;
    }

    int dfsHeight(TreeNode root){
        if (root==null) return 0;

        int lh = dfsHeight(root.left);
        if (lh==-1) return -1;
        int rh = dfsHeight(root.right);
        if (rh==-1) return -1;

        if (Math.abs(lh-rh)>1) return -1;
        return 1+ Math.max(lh, rh);
    }
}
