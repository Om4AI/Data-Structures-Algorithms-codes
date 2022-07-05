public class Solution {
    public int solve(final int[] arr){
        int n = arr.length, ans = 0;
        
        HashMap<Integer,Integer> res[] = new HashMap[n];
        
        for(int i=0; i<n; i++){
            int curr = arr[i];
            res[i] = new HashMap<>();
            for(int j=0; j<i; j++){
                int prev = arr[j], diff= curr-prev;
                int count = res[j].getOrDefault(diff,0)+1;
                HashMap<Integer,Integer> temp = res[i];
                temp.put(diff,count);
                
                res[i] = temp;
                ans = Math.max(ans,count);
            }
        }
        return ++ans;
    }
}
