public class Solution {
    public int solve(int[] A, int[] B, int C) {
        int a = 0, b = 0;
        for(int i=0; i<A.length; i++){
            if(A[i]>C) a++;
        }
        
        for(int i=0; i<B.length; i++){
            if(B[i]<C) b++;
        }
        return Math.max(a,b);
    }
}
