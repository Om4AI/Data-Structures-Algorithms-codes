import java.util.*;

class Solution {
    public int[] findThePrefixCommonArray(int[] arr1, int[] arr2){
        // Find the max positions of all intergers
        int n = arr1.length;
        HashMap<Integer, Integer> greatest_pos = new HashMap<>();
        for (int i=0; i<n; i++){
            int a = arr1[i];
            if (greatest_pos.containsKey(a)){
                greatest_pos.put(a, Math.max(i, greatest_pos.get(a)));
            }else greatest_pos.put(a, i);

            int b = arr2[i];
            if (greatest_pos.containsKey(b)){
                greatest_pos.put(b, Math.max(i, greatest_pos.get(b)));
            }else greatest_pos.put(b, i);
        }

        // Find how many numbers get added at a position
        int[] add_pos = new int[n];
        for (int i=1; i<=n; i++){
            add_pos[greatest_pos.get(i)]++;
        }
        int curr = 0;
        for (int i=0; i<n; i++){
            curr += add_pos[i];
            add_pos[i] = curr;
        }
        return add_pos;
    }
}