// Code by @Om
class Solution {
    public int maxDepth(Node root) {
        int max = 0;
        if (root==null) return 0;
        else{
            // Get the maximum depth from the children
            for (Node n: root.children){
                max = Math.max(maxDepth(n), max);
            } //max variable contains the maximum depth at the current node
        }
        return max+=1;
    }
}
