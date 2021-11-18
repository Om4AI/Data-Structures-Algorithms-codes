class Solution {
    public int[] productExceptSelf(int[] arr){
        int n = arr.length;
        int leftmultiply[] = new int[n];
        int[] rightmultiply = new int[n];
        
//         Left Multiplication
        int left=1,right=1;
        for (int i=0; i<n; i++){
            leftmultiply[i] = left*arr[i];
            left = leftmultiply[i];
        }
//         Right Multiplication
        for (int i=n-1; i>=0; i--){
            rightmultiply[i] = right*arr[i];
            right = rightmultiply[i];
        }
        
//         Final result
        int[] res = new int[n];
        for(int i=0; i<n; i++){
            if(i-1<0) res[i] = rightmultiply[i+1];
            else if(i+1>=n) res[i] = leftmultiply[i-1];
            else res[i] = leftmultiply[i-1]*rightmultiply[i+1];
        }
        return res;
    }
}
