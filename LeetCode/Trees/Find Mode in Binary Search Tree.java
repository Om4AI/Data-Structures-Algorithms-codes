// Code by @Om

import java.util.*;
class Solution {

    int max_count = 1;

    // Overload the function findMode to get mode of the tree
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap();
        findMode(root, map);
        int modes[] = new int[map.size()];
        int i = 0;
        for (int key: map.keySet()){
            if (map.get(key)==max_count){
                modes[i] = key;
                i++;
            }
        }
        return Arrays.copyOf(modes, i);
    }

    public void findMode(TreeNode root, Map<Integer, Integer> map){
        // Leaf node
        if (root==null) return;
        // Root's value is already a key
        else if (map.containsKey(root.val)){
            int count = map.get(root.val)+1;
            map.put(root.val, count);
            max_count = Math.max(count, max_count);
        }else{
            map.put(root.val, 1);
        }

        findMode(root.left, map);
        findMode(root.right, map);
    }
}
