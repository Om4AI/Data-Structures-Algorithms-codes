// APPROACH 1 - PREFIX SUM
// Prefix Sum Approach - O(n^2)
class Solution {
    public int minSubArrayLen(int target, int[] arr) {
        // Create sum arrays
        int sum = 0, n = arr.length;
        int left[] = new int[n];
        int right[] = new int[n];

        for(int i=0; i<n; i++){
            sum+=arr[i];
            left[i] = sum;
        }

        sum=0;
        for(int i=n-1; i>=0; i--){
            sum+=arr[i];
            right[i] = sum;
        }

        // Find all the sum pairs
        int min_els = Integer.MAX_VALUE, total = left[n-1];
        if(total<target) return 0;
        for(int i=0; i<n; i++){
            int t = 0;
            for(int j=i; j<n; j++){
                if(i==0) t = left[j];
                else if(j==n-1) t = total-left[i-1];
                else{
                    t = total-left[i-1]-right[j+1];
                }

                if(t>=target){
                    min_els = Math.min(min_els,j-i+1);
                    break;
                }
            }
        }
        return min_els;
    }
}
