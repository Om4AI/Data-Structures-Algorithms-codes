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

// Brute force solution - 15ms
// class Solution {
//     public int getSum(TreeNode root){
//         if (root==null) return 0;

//         return root.val + getSum(root.left) + getSum(root.right);
//     }

//     public int getNodeCount(TreeNode root){
//         if (root==null) return 0;

//         return 1 + getNodeCount(root.left) + getNodeCount(root.right);
//     }

//     public int averageOfSubtree(TreeNode root) {
//         // Edge case - Single node
//         if (root==null) return 0;

//         int sum = getSum(root);
//         int nodecount = getNodeCount(root);
//         if (root.val == (sum/nodecount)){
//             return 1 + averageOfSubtree(root.left) + averageOfSubtree(root.right);
//         }
//         return averageOfSubtree(root.left) + averageOfSubtree(root.right);
//     }
// }


// Optimized solution - 1ms
class Solution {
    private int subtrees = 0;
    public int averageOfSubtree(TreeNode root) {
        getSumCount(root);
        return subtrees;
    }

    public int[] getSumCount(TreeNode root){
        // Edge case - Root is null
        if (root==null){
            return new int[]{0,0};
        }

        int[] leftSubtree = getSumCount(root.left);
        int[] rightSubtree = getSumCount(root.right);

        int sum = leftSubtree[0] + rightSubtree[0] + root.val;
        int count = leftSubtree[1] + rightSubtree[1] + 1;

        // Increment the counter if average==root value
        if ((sum/count) == root.val){
            subtrees++;
        }
        return new int[]{sum, count};
    }
}