class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res = new ArrayList<>();
        
        if(root1==null && root2==null) return res;
        if(root1!=null && root2==null){
            res.add(root1.val);
            res.addAll(getAllElements(root1.left, null));
            res.addAll(getAllElements(root1.right, null));
        }else if(root1==null && root2!=null){
            res.add(root2.val);
            res.addAll(getAllElements(null, root2.left));
            res.addAll(getAllElements(null, root2.right));
        }else{
            res.add(root1.val);
            res.add(root2.val);
            res.addAll(getAllElements(root1.left, root2.left));
            res.addAll(getAllElements(root1.right, root2.right));
        }
        Collections.sort(res);
        return res;
    }
}