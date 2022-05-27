import java.util.*;
class Solution {
    public int[] recoverTree(TreeNode root){
        List<Integer> inorder = inOrderTraversal(root);
        List<Integer> actual = new ArrayList<>(inorder);
        Collections.sort(actual);
        
        int a = 0, b = 0 ;
        for(int i=0; i<inorder.size(); i++){
            if(inorder.get(i)!=actual.get(i)){
                a = inorder.get(i);
                b = actual.get(i);
            }
        }
        return new int[]{a,b};   
    }
    
    public static List<Integer> inOrderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        
//         Base case
        if(root==null) return res;
        
//         Inorder traversal
        res.addAll(inOrderTraversal(root.left));
        res.add(root.val);
        res.addAll(inOrderTraversal(root.right));
        
        return res;
    }
}
