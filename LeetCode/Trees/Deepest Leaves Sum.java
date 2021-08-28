import java.util.*;
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        // BT Level Order Traversal
        if (root==null) return 0;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        int sum = 0;
        while(!q.isEmpty()){
            sum = 0;
            int size = q.size();
            List<Integer> list = new ArrayList();
            for (int i=0; i<size; i++){
                TreeNode n = q.remove();
                list.add(n.val);
                if (n.left!=null)q.add(n.left);
                if (n.right!=null)q.add(n.right);
            }
            for (int i:list) sum+=i;
        }
        return sum;
    }
}
