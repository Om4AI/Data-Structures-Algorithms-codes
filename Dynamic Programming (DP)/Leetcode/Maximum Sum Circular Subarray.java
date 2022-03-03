class Solution {
    public int maxSubarraySumCircular(int[] arr){
        int max_sum = arr[0], max_curr = arr[0], min_sum = arr[0], min_curr=arr[0], total = arr[0];
        
        // Kadane's Algorithm
        for(int i=1; i<arr.length; i++){
            max_curr = Math.max(max_curr+arr[i], arr[i]);
            max_sum = Math.max(max_sum, max_curr);

            min_curr = Math.min(min_curr+arr[i], arr[i]);
            min_sum = Math.min(min_sum, min_curr);

            total+=arr[i];
        }
        
        // If all elements are negative then max_sum will be -ve then return that 
        // Else return the max(max, (total-min))
        return max_sum<0 ? max_sum : Math.max(max_sum, total-min_sum);
    }
}