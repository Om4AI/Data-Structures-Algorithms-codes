// Code by @Om Mule
// Time Complexity: O(log(N))
// Runtime: 0ms 

public class Solution {
    public int findPeakElement(int[] nums) {
//         Call to search function
        return search(nums, 0, nums.length - 1);
    }
    
    public int search(int[] nums, int l, int r) {
//         Only 1 element in the array (single element remaining)
        if (l == r)
            return l;
//         Find midpoint
        int mid = (l + r) / 2;
//         Decreasing slope: Max on left side
        if (nums[mid] > nums[mid + 1])
            return search(nums, l, mid);
//         Increasing slope: Max on right side
        return search(nums, mid + 1, r);
    }
}
