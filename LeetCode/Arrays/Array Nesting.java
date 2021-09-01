// Brute force
import java.util.*;

class Solution {
    public int arrayNesting(int[] nums) {
        int max_len = Integer.MIN_VALUE;
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i<len; i++){
            map.put(i, nums[i]);
        }
        for (int i=0; i<len; i++){
            // Find s[i] for each value
            HashSet<Integer> set = new HashSet<>();
            int n = nums[i], f = 1;
            set.add(nums[i]);
            while (n!=-1){
                int n1 = map.get(n);
                map.put(n, -1);
                n = n1;
                // Check if value in set
                if (set.contains(n)){
                    break;
                }else set.add(n);
            }
            max_len = Math.max(set.size(), max_len);
            if (max_len==len) break;
        }
        return max_len;
    }
}

// Optimized code
import java.util.*;

class Solution {
    public int arrayNesting(int[] nums) {
        int max_len = Integer.MIN_VALUE,len = nums.length;
        for (int i=0; i<len; i++){
            int size = 0;
            for (int k=i; nums[k]>=0; size++){
                int ak = nums[k];
                nums[k] = -1;
                k = ak;
            }
            max_len = Math.max(max_len,size);
        }
        return max_len;
    }
}
