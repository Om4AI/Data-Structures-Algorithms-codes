// Code by @Om

import java.util.*;
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = getNodes(root1);
        List<Integer> l2 = getNodes(root2);

        return l1.equals(l2);
    }

    public static List<Integer> getNodes(TreeNode root){
        List<Integer> res = new ArrayList<Integer>();

        // Base condition
        if(root==null) return res;

        if(root.left==null && root.right==null) res.add(root.val); 
        else{
            res.addAll(getNodes(root.left));
            res.addAll(getNodes(root.right));
        }

        return res;
    }
}
