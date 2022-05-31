class Solution {
    public void flatten(TreeNode root) {
        // Find the preorder traversal
        List<Integer> preorder = preorderTraversal(root);

        // Base Case
        if(preorder.size()==0) return ;

        // Build Tree
        root = buildTree(root,preorder);
    }

    public static List<Integer> preorderTraversal(TreeNode root){
        List<Integer> l = new ArrayList<>();

        // Base case
        if(root==null) return l;

        l.add(root.val);
        l.addAll(preorderTraversal(root.left));
        l.addAll(preorderTraversal(root.right));
        return l;
    }

    public static TreeNode buildTree(TreeNode root, List<Integer> preorder){
        root.val = preorder.get(0);
        TreeNode p = root;

        // Construct tree using Preorder
        for(int i=0; i<preorder.size()-1; i++){
            p.left = null;
            p.right = new TreeNode(preorder.get(i+1));
            p = p.right;
        }
        return root;
    }
}