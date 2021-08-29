import java.util.*;
class Solution {
    List<Integer> list;
    int f = 0;
    public TreeNode bstToGst(TreeNode root) {
        if (root==null) return null;
        if (f==0){
            list= get_els(root);
            Collections.sort(list);
            f=1;
        }
        int a = list.indexOf(root.val);
        for (int i=a+1; i<list.size(); i++){
            root.val+=list.get(i);
        }
        bstToGst(root.left);
        bstToGst(root.right);
        return root;
    }

    public List<Integer> get_els(TreeNode root){
        List<Integer> list = new ArrayList();
        if (root==null) return list;
        list.add(root.val);
        list.addAll(get_els(root.left));
        list.addAll(get_els(root.right));
        return list;
    }
}
