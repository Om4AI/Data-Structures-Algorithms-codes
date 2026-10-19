import java.util.*;

// O(nlogn) - Sorting approach (5ms) - Brute force
class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i=0; i<nums.length; i++){
            if (nums[i]==target) res.add(i);
        }
        return res;
    }
}


// O(n) approach - Optimized approach without sorting
// Count the number of elements lesser than and equal to target & return accordingly
class Solution {
    public List<Integer> targetIndices(int[] arr, int target) {
        int n = arr.length, lesser = 0, equal = 0;
        for (int i=0; i<n; i++){
            if (arr[i]<target) lesser++;
            else if (arr[i]==target) equal++;
        }

        List<Integer> res = new ArrayList<>();
        for (int i=lesser; i<lesser+equal; i++) res.add(i);
        return res;
    }
}