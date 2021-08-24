// Code by @Om
import java.util.*;
class Solution {
    List<Integer> list = new ArrayList();
    public boolean findTarget(TreeNode root, int k) {
        if (root==null) return false;
        get_nodes(root);
        Collections.sort(list);
        return check_2sum(k);
    }

    // Two Pointer Approach
    public boolean check_2sum(int k){
        boolean res = false;
        int i=0, j = list.size()-1;
        while (i<j){
            int sum = list.get(i)+list.get(j);
            if (sum == k){
                res = true;
                break;
            }else if (sum<k){
                i++;
            }else{j--;}
        }
        return res;
    }

    public List<Integer> get_nodes(TreeNode root){
        List<Integer> t= new ArrayList<Integer>();
        if (root==null) return t;
        list.add(root.val);
        list.addAll(get_nodes(root.left));
        list.addAll(get_nodes(root.right));
        return t;
    }
}
