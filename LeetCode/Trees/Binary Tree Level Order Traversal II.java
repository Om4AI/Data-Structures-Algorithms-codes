class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null) return res;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> l = new ArrayList<>();
            for (int i=0; i<size; i++){
                TreeNode node = q.poll();
                l.add(node.val);
                if (node.left!=null) q.add(node.left);
                if (node.right!=null) q.add(node.right);
            }
            res.add(l);
        }
        Collections.reverse(res);
        return res;
    }
}
