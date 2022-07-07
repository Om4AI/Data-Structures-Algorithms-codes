public class Solution {  
    public int maxProduct(int[] arr) {
        int temp = 1, res = Integer.MIN_VALUE;
        
        // Left to right pass
        for(int i: arr){
            temp *= i;
            res = Math.max(res,temp);
            // Restart after a zero
            if(temp==0) temp = 1;
        }
        temp = 1;
        
        // Right to Left pass considering all cases
        for(int i=arr.length-1; i>=0; i--){
            temp *= arr[i];
            res = Math.max(res,temp);
            temp = (temp==0)?1:temp;
        }
        return res;
    }
}
