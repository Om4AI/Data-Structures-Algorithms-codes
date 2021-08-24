// Code by @Om
import java.util.*;
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {

        // Initialize list of doubles
        List<Double> list = new ArrayList();

        // Empty Tree case
        if (root==null) return list;

        // Initialize Queue for BFS
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            double sum = 0; // Sum of all elements on a lvl
            for (int i=0; i<size; i++){
                TreeNode n = queue.remove();
                sum += n.val;
                if (n.left!=null) queue.add(n.left);
                if (n.right!=null)queue.add(n.right);
            }
            double avg = sum/size;
            list.add(avg);
        }
        return list;
    }
}
