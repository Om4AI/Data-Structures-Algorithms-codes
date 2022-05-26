import java.util.*;
class Solution {
    public List<Integer> rightSideView(TreeNode root){
        List<List<Integer>> l = levelOrderTraversal(root);
        List<Integer> res = new ArrayList<>();
        for(List<Integer> list: l){
            res.add(list.get(list.size() - 1));
        }
        return res;
    }
    
    public static List<List<Integer>> levelOrderTraversal(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();

        // Base Case
        if(root==null) return res;

        // Initialize the Queue and add root node
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        // Loop for BFS traversal
        while(!q.isEmpty()){
            List<Integer> l = new ArrayList<>();
            int n = q.size();
            while(n-->0){
                TreeNode node = q.poll();
                l.add(node.val);

                // Add children
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            res.add(l);
        }
        return res;
    }
}