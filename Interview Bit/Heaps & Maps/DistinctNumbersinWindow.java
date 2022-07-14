import java.util.*;
public class Solution {
    public static int[] dNums(int[] arr, int k){
        int n = arr.length;

        // Base case
        if(k>n) return new int[]{};

        int res[] = new int[n-k+1];
        
        // Actual sliding window approach
        HashMap<Integer,Integer> map = new HashMap<>();
        int s = 0, e = k-1, p = 1;
        
        // Create first window
        for(int i=0; i<k; i++) map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        res[0] = map.size();

        // Loop through the other elements
        while(s<=e && e<n-1){
            // Remove previous element
            if(map.get(arr[s])==1) map.remove(arr[s]);
            else map.put(arr[s], map.get(arr[s])-1);

            // Add new element
            e++;
            map.put(arr[e], map.getOrDefault(arr[e], 0)+1);
            res[p] = map.size();
            p++;
            s++;
        }
        return res;
    }
}
