/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public static StringBuffer sb;
    public static void preOrder(TreeNode root){
        sb.append(Integer.toString(root.val));
        if (root.left!=null){
            sb.append("(");
            preOrder(root.left);
            sb.append(")");
        }
        if (root.right!=null){
            if (root.left==null){
                sb.append("()");
            }
            sb.append("(");
            preOrder(root.right);
            sb.append(")");
        }
    }


    public String tree2str(TreeNode root){
        sb = new StringBuffer();
        preOrder(root);
        return sb.toString();
    }
}