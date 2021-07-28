// N- ary Postorder Tree Traversal: Java

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> l = new ArrayList();
        if (root!=null){
            for (Node n: root.children){
                l.addAll(postorder(n));
            }
            l.add(root.val);
        }
        return l;
    }
}
