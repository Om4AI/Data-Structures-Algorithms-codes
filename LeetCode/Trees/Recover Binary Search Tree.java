class Solution {
    public void recoverTree(TreeNode root){
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
        modifyTree(root,a,b,-1,-1);
    }
    

    
    // ------------------ModifyTree Function --------------------
    public static void modifyTree(TreeNode root, int v1, int v2, int fv1, int fv2){
        // Base Case
        if(root==null) return;
        
        // Modify the root node value
        if(root.val==v1 && fv1==-1){
            root.val = v2;
            fv1 = 1;
        }else if(root.val==v2 && fv2==-1){
            root.val = v1;
            fv2 = 1;
        }
        
        // Recursive call on subtrees
        modifyTree(root.left,v1,v2,fv1,fv2);
        modifyTree(root.right,v1,v2,fv1,fv2);
    }
    


    // ------------------InOrderTraversal----------------
    public static List<Integer> inOrderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        
        // Base case
        if(root==null) return res;
        
        // Inorder traversal
        res.addAll(inOrderTraversal(root.left));
        res.add(root.val);
        res.addAll(inOrderTraversal(root.right));
        
        return res;
    }
}
