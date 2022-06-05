class Solution {
    HashMap<Integer, List<TreeNode>> map = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        if(!map.containsKey(n)){
            // List to be returned
            List<TreeNode> res = new LinkedList<>();

            if(n==1){
                res.add(new TreeNode(0));
            }else if (n%2==1){
                // Odd number of nodes
                // Loop through for every value of x from 0->n

                for(int x=0; x<n; x++){
                    // y -> Number of nodes left after putting 1 left node and x further nodes
                    int y = n-x-1;
                    for(TreeNode left: allPossibleFBT(x)){
                        for(TreeNode right: allPossibleFBT(y)){
                            TreeNode newtree = new TreeNode(0);
                            newtree.left = left;
                            newtree.right = right;
                            res.add(newtree);
                        }
                    }
                }
            }
            map.put(n,res);
        }
        return map.get(n);
    }
}
