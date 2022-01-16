// Optimized Approach [Accepted 100% faster]
class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = queries.length;
        int xors[] = new int[arr.length];

        // Fill up the XOR array
        int xor = arr[0];
        xors[0] = xor;
        for(int i=1; i<arr.length; i++){
            xor = xor^arr[i];
            xors[i] = xor;
        }

        int res[] = new int[n];
        for(int i=0; i<n; i++){
          // Start & End points
            int m = queries[i][0], n1 = queries[i][1];
          
          //Main Logic
            if(m==0) res[i] = xors[n1];
            else res[i] = xors[n1]^xors[m-1];
        }
        return res;
    }
}
