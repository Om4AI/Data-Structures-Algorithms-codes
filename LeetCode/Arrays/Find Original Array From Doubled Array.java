import java.util.*;

class Solution {
    public int[] findOriginalArray(int[] arr) {
        int n = arr.length;
        int p = 0;
        
        // Base case - Number of elements is odd
        if(n%2!=0) return new int[]{};
        int res[] = new int[n/2];

        // Sort array
        Arrays.sort(arr);

        // Traverse elements and for every element, if it is not in hashmap, then add it to hashmap and also the occurence
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            int el = arr[i];
            if(!map.containsKey(el)){
                map.put(el*2, map.getOrDefault(el*2,0)+1);
                if(p<(n/2)){
                    res[p] = el;
                    p++;
                }else return new int[]{};
            }
            else{
                if(map.get(el)==1) map.remove(el);
                else map.put(el, map.get(el)-1);
            }
        }
        return res;
    }
}