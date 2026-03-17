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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        // Edge case
        if (root==null) return res;

        // Normal case
        Queue<TreeNode> q = new LinkedList<>();
        String dir = "l2r";
        q.add(root);
        while (!q.isEmpty()){
            int n = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i=0; i<n; i++){
                TreeNode node = q.poll();
                level.add(node.val);
                if (node.left!=null){
                    q.add(node.left);
                }
                if (node.right!=null){
                    q.add(node.right);
                }
            }

            if (dir.equals("l2r")){
                res.add(level);
                dir = "r2l";
            }else if (dir.equals("r2l")){
                Collections.reverse(level);
                res.add(level);
                dir = "l2r";
            }
        }
        return res;
    }
}
