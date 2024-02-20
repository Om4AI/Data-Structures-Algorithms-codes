class Solution {
    public int missingNumber(int[] arr) {
        // Maximum number [0,n]
        int n = arr.length;

        // Check element presence status
        int status[] = new int[n+1];
        for(int i=0; i<n; i++){
            status[arr[i]] = 1;
        }

        // Find missing element
        for(int i=0; i<n+1; i++){
            if (status[i]==0) return i;
        }
        return n+1;
    }
}