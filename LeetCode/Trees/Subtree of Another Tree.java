class Solution {
    int f = 0;
    public boolean isSubtree(TreeNode root, TreeNode subroot) {

        if(root==null && subroot==null) return true; 
        else if (root==null || subroot==null) return false;
        if (f==0 && root.val==subroot.val){
            if (istree_identical(root,subroot)){f=1;}
        }
        if (f==0){
            if (isSubtree(root.left,subroot) || isSubtree(root.right,subroot)){f=1;}
        }
        if (f==1) return true;
        else return false;
    }

    public boolean istree_identical(TreeNode r1, TreeNode r2){
        if (r1==null && r2==null){
            return true;
        }else if (r1==null || r2==null){
            return false;
        }
        else if (r1.val==r2.val){
            // Check left & right subtrees
            if (istree_identical(r1.left, r2.left) && istree_identical(r1.right, r2.right)) return true;
            else return false;
        }else return false;
    }
}
