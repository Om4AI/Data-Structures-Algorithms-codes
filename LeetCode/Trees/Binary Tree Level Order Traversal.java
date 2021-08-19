// Code by @Om
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if (root==null) return res;

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);

        // Queue Operations
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> l = new ArrayList();
            for(int i=0; i<size; i++){
                TreeNode node = queue.remove();
                l.add(node.val);
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
            res.add(l);
        }
        return res;
    }
}
