// Code by @Om

import java.util.*;
class Solution {
    HashMap<Integer, Integer> map = new HashMap();
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root==null) return false;
        map.put(root.val, -1);
        get_parchild(root);
        int f = 0;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            HashSet<Integer> lvl = new HashSet();
            for (int i=0; i<size; i++){
                TreeNode n = queue.remove();
                lvl.add(n.val);

                if (n.left!=null) queue.add(n.left);
                if (n.right!=null) queue.add(n.right);
            }
            System.out.println(lvl);
            // Check cousins
            if ((lvl.contains(x) && lvl.contains(y)) && (map.get(x)!=map.get(y))) f=1;
        }
        if (f==1) return true;
        else return false;
    }
  
//   Get Pairs of Parent & Children
    public void get_parchild(TreeNode root){
        if (root==null) return;
        if (root.left==null && root.right==null) return;
        if (root.left!=null){
            map.put(root.left.val , root.val);
        }
        if (root.right!=null){
            map.put(root.right.val, root.val);
        }

        // Left subtree call
        get_parchild(root.left);
        get_parchild(root.right);
    }
}
