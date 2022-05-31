public class Solution {    
    List<Integer> inorder = new ArrayList<>();
    int index = -1;

    public Solution(TreeNode root) {
        inorder = InorderTraversal(root);
    }
    
    public int next() {
        index++;
        return inorder.get(index);
    }
    
    public boolean hasNext() {
        if(index<(inorder.size()-1)) return true;
        return false;
    }

    public static List<Integer> InorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();

        if(root==null) return res;

        res.addAll(InorderTraversal(root.left));
        res.add(root.val);
        res.addAll(InorderTraversal(root.right));
        return res;
    }
}


