class Solution {
    public int[] getMaximumXor(int[] arr, int maximumBit) {
        int n = arr.length, p=0, k = (1<<maximumBit) - 1;
        int res[] = new int[n];

        // Find total xor
        int xor = arr[0];
        for(int i=1; i<n; i++){
            xor = xor^arr[i];
        }

        // Actual loop
        while(p<n){
            // a^b=c --> a^c=b (Here c is always constant 2^maxbit-1)
            res[p] = xor^k;
            // Remove last element from array
            xor = xor^arr[n-1-p];
            p++;
        }
        return res;
    }
}