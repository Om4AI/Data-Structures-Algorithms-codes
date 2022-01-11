import java.util.*;
class Solution {
    public int minSwaps(int[] nums){
        int ones=0, n=nums.length, op=0;

        // Count number of 1s'
        for(int i:nums){
            if(i==1) ones++;
        }

        // Append nums to itself
        int arr[] = new int[n*2];
        for(int i=0; i<n*2; i++){
            arr[i] = nums[i%n];
        }

        // First window
        for(int i=0; i<ones; i++) if(arr[i]==1) op++;
        int maxones = op;

        for(int i=ones; i<n*2; i++){
            if(arr[i-ones]==1) op--;
            if(arr[i]==1) op++;
            maxones = Math.max(maxones, op);
        }
        return ones-maxones;
    }
}