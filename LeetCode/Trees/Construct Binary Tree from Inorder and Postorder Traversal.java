import java.util.*;
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null||postorder == null|| inorder.length!=postorder.length) return null;
        
        // Hashmap for inorder index sorting
        HashMap<Integer, Integer> map = new HashMap();
        for (int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, map);
    }

    public TreeNode buildTree(int[] inorder, int instart, int inend, int[] postorder, int postart, int poend, HashMap<Integer, Integer> map){
        if (postart>poend || instart>inend) return null;
        TreeNode root = new TreeNode(postorder[poend]);
        int rtin = map.get(postorder[poend]);
        TreeNode leftchild = buildTree(inorder,instart,rtin-1,postorder,postart,postart+rtin-instart-1, map);
        TreeNode rightchild = buildTree(inorder,rtin+1,inend,postorder,postart+rtin-instart,poend-1, map);
        root.left = leftchild;
        root.right = rightchild;
        return root;
    }
}
