import java.util.*;
class Solution {
    static HashMap<String, Boolean> map;
    public boolean splitArraySameAverage(int[] arr){
        map = new HashMap<>();
        return canSplit(0,0,0,0,arr.length,arr);
    }

    public static boolean canSplit(int s1, int s2, int l1, int l2, int n, int[] arr){
        
        // Construct string for map
        StringBuffer sb = new StringBuffer();
        sb.append(String.valueOf(s1));
        sb.append(" ");
        sb.append(String.valueOf(s2));
        sb.append(" ");
        sb.append(String.valueOf(n));
        String key = sb.toString();
        
        // Base case
        if((n==0) && (s1>0) && (s1==s2) && l1>0 && l2>0){
            map.put(key, true); 
            return map.get(key);
        }
        else if (n==0){
            map.put(key, false);
            return map.get(key);
        }

        // Memoization check
        if(map.containsKey(key)) return map.get(key);

        int sum1 = s1*l1 + arr[n-1];
        int sum2 = s2*l2 + arr[n-1];
        
        boolean res = canSplit((sum1/(l1+1)),s2,l1+1,l2,n-1,arr) || canSplit(s1, (sum2/(l2+1)), l1, l2+1, n-1, arr);
        map.put(key, res);
        return map.get(key);
    }
}