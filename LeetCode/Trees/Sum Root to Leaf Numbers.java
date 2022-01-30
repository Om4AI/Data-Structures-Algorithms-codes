import java.util.*;
class Solution {
    int res = 0;
    public int sumNumbers(TreeNode root){
        getNums(root, new String());
        return res;
    }
    
    public void getNums(TreeNode root, String s){
        StringBuffer sb = new StringBuffer(s);
        if(root==null) return;
        if(root.left==null && root.right==null){
            sb.append(String.valueOf(root.val));
            res += Integer.parseInt(sb.toString());
            return;
        }
        
        sb.append(String.valueOf(root.val));
        getNums(root.left, sb.toString());
        getNums(root.right, sb.toString());
    }
}