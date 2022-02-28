import java.util.*;
class Solution {
    public int numberOfSubarrays(int[] arr, int k) {
        // Initialize
        int n = arr.length, sum=0,res =0;
        for(int i=0; i<n; i++) arr[i] = (arr[i]%2==0)?0:1;

        // Calculate prefix-sum array
        for(int i=0; i<n; i++){
            sum+=arr[i];
            arr[i] = sum;
        }

        // Create occurences HashMap
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        // Counting subarrays
        for(int key:map.keySet()){
            if(key>=k){
                int occ = map.get(key);
                res+=occ;
                if(map.containsKey(key-k)){
                    if((key-k)==0) res+= (occ*(map.get(key-k)));
                    else res+=(occ*(map.get(key-k)-1));
                }
            }
        }
        return res;
    }
}