class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
//         Recursive method 
        if (p==null && q==null){
            return true;
        }else if (p==null || q==null){
            return false;
        }
        else{
            if (p.val==q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right)){
                return true;}
            else{
                return false;
                }
        }
    }
}
