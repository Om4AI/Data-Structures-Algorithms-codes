import java.util.*;

class Solution {
    public int lis(int[] arr) {
        int n = arr.length, res = 0;

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            int curr = arr[i];
            int max = 0;
            for(int j=0; j<i; j++){
                int prev = arr[j];
                if(curr>prev){
                    max = Math.max(max,map.get(j));
                }
            }
            res = Math.max(res,max+1);
            map.put(i,max+1);
        }
        return res; 
    }
}