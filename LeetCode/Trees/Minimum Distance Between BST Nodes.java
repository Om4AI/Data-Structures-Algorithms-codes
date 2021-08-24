// Code by @Om
import java.util.*;
class Solution {
    List<Integer> list = new ArrayList<Integer>();
    public int minDiffInBST(TreeNode root) {
        if (root==null) return 0;
        get_nodes(root);
        Collections.sort(list);
        
        // Get the minimum difference
        int min = Integer.MAX_VALUE;
        for (int i=0; i<list.size()-1; i++){
            min = Math.min((list.get(i+1)-list.get(i)),min);
        }
        return min;
    }

    public List<Integer> get_nodes(TreeNode root){
        List<Integer> t = new ArrayList<Integer>();
        if (root==null) return t;
        list.add(root.val);
        list.addAll(get_nodes(root.left));
        list.addAll(get_nodes(root.right));
        return t;
    }
}
