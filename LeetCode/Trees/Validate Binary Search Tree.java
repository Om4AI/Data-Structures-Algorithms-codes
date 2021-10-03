// Code by @Om
class Solution {
    public boolean isValidBST(TreeNode root) {
//         Single node case
        if (root.left==null && root.right==null) return true;
        
        List<Integer> right = get_nodes(root.right);
        if (root.left==null && isValidBST(root.right) && Collections.min(right)>root.val) return true;
        
        List<Integer> left = get_nodes(root.left);
        if (root.right==null && isValidBST(root.left) && Collections.max(left)<root.val) return true;
        else if (root.left==null || root.right==null) return false;
        
        left = get_nodes(root.left);
        right = get_nodes(root.right);
        
        if (Collections.max(left)<root.val && Collections.min(right)>root.val && isValidBST(root.left) && isValidBST(root.right))return true;
        else return false;
    }
    
    public List<Integer> get_nodes(TreeNode root){
        List<Integer> l = new ArrayList<>();
        
        if (root==null) return l;
        l.add(root.val);
        l.addAll(get_nodes(root.left));
        l.addAll(get_nodes(root.right));
        return l;
    }
}
