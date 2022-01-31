class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target){
        List<TreeNode> list = getNodes(cloned);
        for (TreeNode node: list){
            if(node.val==target.val) return node;
        }
        return target;
    }

    public static List<TreeNode> getNodes(TreeNode root){
        List<TreeNode> list = new ArrayList<>();

        if(root==null) return list;
        list.add(root);
        list.addAll(getNodes(root.left));
        list.addAll(getNodes(root.right));
        return list;
    }
}