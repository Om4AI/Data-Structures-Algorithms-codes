class Solution {
    public int maxProduct(int[] arr) {
        if(arr.length==1) return arr[0];
        
        // Initialization
        int curr_max = 1, curr_min= 1, res = 0;
        for(int n:arr){
            if(n==0){
                curr_max = 1;
                curr_min = 1;
                continue;
            }
            // Update curr_max & curr_min
            int temp = curr_max*n;
            curr_max = Math.max(Math.max(temp, curr_min*n),n);
            curr_min = Math.min(Math.min(temp, curr_min*n),n);
            res = Math.max(res, curr_max);
        }
        return res;
    }
}
