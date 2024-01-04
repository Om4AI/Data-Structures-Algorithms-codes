import java.util.*;

class Solution {
    public int minOperations(int[] arr) {
        int n = arr.length, ops = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        // Fill the occurences of every element
        for (int i=0; i<n; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        System.out.println(map);
        for (int key: map.keySet()){
            int occ = map.get(key);
            if (occ==1) return -1;
            else if (occ%3==0) ops+=occ/3;
            else ops+=((occ/3)+1);
        }

        return ops;
    }
}