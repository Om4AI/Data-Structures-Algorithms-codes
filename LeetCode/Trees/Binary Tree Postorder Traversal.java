// PostOrder Traversal using recursive technique in Java

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList();
        if (root!=null){
            l.addAll(postorderTraversal(root.left));
            l.addAll(postorderTraversal(root.right));
            l.add(root.val);
        }
        return l;
    }
}
