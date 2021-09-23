import java.util.*;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        List<Integer> l = new ArrayList<>();
        for (int i=0; i<nums1.length; i++){
            map1.put(nums1[i], map1.getOrDefault(nums1[i], 0)+1);
        }
        for (int i=0; i<nums2.length; i++){
            map2.put(nums2[i], map2.getOrDefault(nums2[i], 0)+1);
        }

        // Check intersection
        for (int k: map1.keySet()){
            if (map2.containsKey(k)){
                int inst = Math.min(map1.get(k), map2.get(k));
                for (int i=0; i<inst; i++) l.add(k);
            }
        }
        int res[] = new int[l.size()];
        for (int i=0; i<l.size(); i++){
            res[i] = l.get(i);
        }
        return res;
    }
}
