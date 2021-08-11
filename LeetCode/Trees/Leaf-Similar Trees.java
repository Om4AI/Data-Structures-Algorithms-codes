// Code by @Om

import java.util.*;
class Solution {

    static List<Integer> get_leaves(TreeNode root){
        List<Integer> list = new ArrayList();
        if (root==null) return list;
        if (root.left==null && root.right==null){
            list.add(root.val);
        }
        else{
            List<Integer> l = get_leaves(root.left);
            List<Integer> r = get_leaves(root.right);
            list.addAll(l);
            list.addAll(r);
        }
        return list;
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> first = get_leaves(root1);
        List<Integer> second = get_leaves(root2);
        return first.equals(second);
    }
}
