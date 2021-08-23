import java.util.*;
class Solution {
    List<TreeNode> l = new ArrayList<>();
    public TreeNode increasingBST(TreeNode root) {
        if (root==null) return null;
        inorder_list(root);

        // Create a tree
        for (int i=0; i<l.size()-1; i++){
            l.get(i).right = l.get(i+1);
            l.get(i).left = null;
        }
        l.get(l.size()-1).right = null;
        l.get(l.size()-1).left = null;

        // Head is the first value in the list
        return l.get(0);
    }

    void inorder_list(TreeNode root){
        if (root==null) return;

        inorder_list(root.left);
        l.add(root);
        inorder_list(root.right);
    }
}
