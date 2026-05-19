// Approach -
//      1. Perform level order traversal
//      2. For every level, find the largest node using a level_max variable

class Solution {
    public List<Integer> largestValues(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root==null) return res;
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            int level_max = Integer.MIN_VALUE;
            for (int i=0; i<n; i++){
                TreeNode curr = q.poll();
                level_max = Math.max(level_max, curr.val);
                if (curr.left!=null) q.add(curr.left);
                if (curr.right!=null) q.add(curr.right);
            }
            res.add(level_max);
        }
        return res;
    }
}