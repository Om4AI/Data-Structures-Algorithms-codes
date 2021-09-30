// Code by @Om
import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
//         Empty Case
        if (root ==null) return res;
//         General cases
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
        return res;  
    }
}
