// Sliding Window (Accepted - 1500 ms)
class Solution {
    public int numberOfArithmeticSlices(int[] arr) {
        int n = arr.length, count = 0;
        if(n<3) return 0;

        // Sliding Window implementation
        for(int k=3; k<=n; k++){
            List<Integer> l = new ArrayList<>();
            int p = k-1;

            // First sliding window creation
            for(int i=0; i<k; i++) l.add(arr[i]);

            while(p<n){
                int diff = (l.get(1)-l.get(0)), f = 1;
                for(int i=2; i<l.size(); i++){
                    if((l.get(i)-l.get(i-1))!=diff){
                        f = 0;
                        break;
                    }
                }
                if(f==1) count++;

                // Update sliding window
                p++;
                if(p<=n-1){
                    l.remove(0);
                    l.add(arr[p]);
                }else break;
            }
        }
        return count;
    }
}


// Without Sliding Window (Accepted - 0ms)
class Solution {
    public int numberOfArithmeticSlices(int[] arr) {
        int n = arr.length;
        if(n<3) return 0;
        
        int curr = 0, ans = 0;
        
        // Actual logic using curr pointer
        for(int i=2; i<n; i++){
            if(arr[i]-arr[i-1]==arr[i-1]-arr[i-2]){
                // Append element to existing streak
                curr++;
                ans+=curr;
            }else curr = 0;  // New streak start
        }
        return ans;
    }
}