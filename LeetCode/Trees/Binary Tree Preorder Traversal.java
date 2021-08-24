// Preorder Traversal -- Recursive Technique

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList();
        if (root!=null){
            l.add(root.val);
            l.addAll(preorderTraversal(root.left));
            l.addAll(preorderTraversal(root.right));
        }
        return l;
    }
}
