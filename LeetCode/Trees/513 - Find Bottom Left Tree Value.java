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
import java.util.*;
class Solution {
    public static List<List<Integer>> res;
    public int findBottomLeftValue(TreeNode root) {
        res = new ArrayList<>();
        getLevelOrder(root);

        return res.get(res.size()-1).get(0);
    }

    public static void getLevelOrder(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i=0; i<size; i++){
                TreeNode curr = q.poll();
                level.add(curr.val);
                if (curr.left!=null) q.add(curr.left);
                if (curr.right!=null) q.add(curr.right);
            }
            res.add(level);
        }
    }
}