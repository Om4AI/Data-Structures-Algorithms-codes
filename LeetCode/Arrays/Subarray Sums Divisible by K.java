import java.util.*;
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        int tsum = 0, res = 0;
        for (int n: nums){
            // Get the sum till current index
            tsum += n;
            int rem = (tsum%k+k)%k;

            // Zero remainder testcase
            if(rem==0) res++;
            res += map.getOrDefault(rem, 0);

            // Increase the occurence of the remainder
            map.put(rem, map.getOrDefault(rem,0)+1);
        }
        return res;
    }
}
