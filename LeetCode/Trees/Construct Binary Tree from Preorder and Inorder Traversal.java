class Solution {
    public TreeNode buildTree(int[] po, int[] io) {
        List<Integer> preorder = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        
        // Reduction of Time Complexity
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<po.length; i++){
            map.put(po[i],i);
        }
        
        for(int i: po) preorder.add(i);
        for(int i: io) inorder.add(i);
        
        // Start with the recursive call
        return getTree(preorder,inorder,map);
    }
    
    public static TreeNode getTree(List<Integer> preorder, List<Integer> inorder, HashMap<Integer,Integer> map){
        if(inorder.size()==0) return null;
        
        int el = 0, index = Integer.MAX_VALUE;
        
        for(int i: inorder){
            // Reduce TC by using - map.get() instead of preorder.indexOf()
            int tindex = map.get(i);
            if(tindex<index){
                el = i;
                index = tindex;
            }
        }
        // Create new root
        TreeNode root = new TreeNode(el);
        
        // Left & Right subtree
        root.left = getTree(preorder,inorder.subList(0,inorder.indexOf(el)),map);
        root.right = getTree(preorder,inorder.subList(inorder.indexOf(el)+1,inorder.size()),map);
        return root;
    }
}