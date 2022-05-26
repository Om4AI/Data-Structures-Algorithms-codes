class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        // Get the level order traversal
        List<List<Integer>> res = levelOrderTraversal(root);

        // Reverse the alternate level lists
        for(int i=1; i<res.size(); i+=2){
            List<Integer> temp = res.get(i);
            Collections.reverse(temp);
            res.set(i,temp);
        }
        return res;
    }

    public static List<List<Integer>> levelOrderTraversal(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        
        // Base case
        if(root==null) return res;

        // Initialization
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int n = q.size();

            while(n-->0){
                TreeNode node = q.poll();
                level.add(node.val);
                
                // Children
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            res.add(level);
        }
        return res;
    }
}