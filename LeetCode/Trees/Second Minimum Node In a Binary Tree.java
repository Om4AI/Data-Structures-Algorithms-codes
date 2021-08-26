// Code by @Om
import java.util.*;
class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        List<Integer> res = new ArrayList(get_nodes(root));
        Collections.sort(res);
        if (res.size()<2) return -1;
        else return res.get(1);
    }

    public HashSet<Integer> get_nodes(TreeNode root){
        HashSet<Integer> t = new HashSet();
        if (root==null) return t;
        else t.add(root.val);

        // Left & Right nodes
        t.addAll(get_nodes(root.left));
        t.addAll(get_nodes(root.right));
        return t;
    }
}
