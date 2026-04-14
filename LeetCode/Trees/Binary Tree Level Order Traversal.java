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
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i=0; i<n; i++){
                TreeNode polled = q.poll();
                level.add(polled.val);
                if (polled.left != null){
                    q.add(polled.left);
                }
                if (polled.right != null){
                    q.add(polled.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
