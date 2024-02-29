import java.util.*;


/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */

class parentNode{
    TreeNode node;
    int parent;
    parentNode(TreeNode n, int p){
        node = n;
        parent = p;
    }
}

public class Solution {
    public static int element;
    public static int parent;
    public ArrayList<Integer> solve(TreeNode root, int B) {
        element = B;

        List<parentNode> level = levelOrder(root);
        ArrayList<Integer> res = new ArrayList<>();
        // Traverse through the level
        for (int i=0; i<level.size(); i++){
            parentNode curr = level.get(i);
            if (curr.parent != parent) res.add(curr.node.val);
        }
        return res;
    }



    public static List<parentNode> levelOrder(TreeNode root){
        Queue<parentNode> q = new LinkedList<>();
        q.add(new parentNode(root, root.val));

        // Every level in tree
        while (!q.isEmpty()){
            int size = q.size();
            List<parentNode> level = new ArrayList<>();
            boolean this_level = false;

            // Level wise
            for (int i=0; i<size; i++){
                parentNode obj = q.poll();
                TreeNode curr = obj.node;
                if (curr.val==element){
                    this_level=true;
                    parent = obj.parent;
                }

                level.add(obj);
                if (curr.left!=null) q.add(new parentNode(curr.left, curr.val));
                if (curr.right!=null) q.add(new parentNode(curr.right, curr.val));
            }
            if (this_level==true) return level;
        }
        List<parentNode> temp = new ArrayList<>();
        return temp;
    }
}
