class Solution {
    public int longestMonotonicSubarray(int[] arr){
        // Current operation (1: Increasing & -1: Decreasing)
        int c_op = 1, longest = 1, prev = arr[0], res = 1;
        for (int i=1; i<arr.length; i++){
            int curr = arr[i];
            // Increasing or decreasing continues
            if ((curr>prev && c_op==1) || (curr<prev && c_op==-1)){
                longest++;
                prev = curr;
            }else if (curr>prev && c_op==-1){ // Decreasing stops and increasing starts
                res = Math.max(res, longest);
                longest=2;
                c_op = 1;
                prev = curr;
            }else if (curr<prev && c_op==1){ // Increasing stops and decreasing starts
                res = Math.max(res, longest);
                longest=2;
                c_op = -1;
                prev = curr;
            }else{ // Current element is equal to previous (so increasing or decreasing both stop) & count is reset
                res = Math.max(res, longest);
                longest = 1;
                prev = curr;
            }
        }
        res = Math.max(res, longest);
        return res;
    }
}