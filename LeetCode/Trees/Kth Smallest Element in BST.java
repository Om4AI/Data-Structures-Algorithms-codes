// Less Optimized Solution
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if (root==null) return 0;
        List<Integer> l = new ArrayList();
        l.add(root.val);
        l.addAll(get_nodes(root.left));
        Collections.sort(l);
        return l.get(k-1);
    }
    
    public List<Integer> get_nodes(TreeNode root){
        List<Integer> t = new ArrayList<>();
        if (root==null) return t;
        else{
            t.add(root.val);
        }
        t.addAll(get_nodes(root.left));
        t.addAll(get_nodes(root.right));
        return t;
    }
}
