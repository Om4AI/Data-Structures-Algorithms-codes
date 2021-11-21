// N- ary Preorder Tree Traversal: Java

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> l = new ArrayList();
        if (root!=null){
            l.add(root.val);
            for (Node n: root.children){
                l.addAll(preorder(n));
            }
        }
        return l;
    }
}
