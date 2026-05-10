// Approach - 
//     1. Perform the level order traversal
//     2. For each level, find the complete level nodes and add the last value to resultant list

class Solution {
    public List<Integer> rightSideView(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root==null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){
            int n = q.size();
            List<Integer> level = new ArrayList<>();
            while (n-->0){
                TreeNode currNode = q.poll();
                level.add(currNode.val);
                if (currNode.left != null) q.add(currNode.left);
                if (currNode.right != null) q.add(currNode.right);
            }
            res.add(level.get(level.size()-1));
        }
        return res;
    }
}
