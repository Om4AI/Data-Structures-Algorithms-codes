// Memoization Approach

class Solution {
    public static int mod = 1000000007;
    public static long t[][];
    public int countOrders(int n) {
        t = new long[n+1][n+1];

        for(int i=0; i<n+1; i++) Arrays.fill(t[i], -1);
        return (int)getTotalCount(0,n);
    }

    public static long getTotalCount(int picked, int unpicked){
        // Base condition
        if(unpicked==0 && picked==1) return 1;
        if(unpicked<0 || picked<0) return 0;

        if(t[picked][unpicked]!=-1) return t[picked][unpicked];

        long res = (unpicked*getTotalCount(picked+1, unpicked-1));
        res%=mod;
        res += (picked*getTotalCount(picked-1, unpicked));
        res%=mod;

        t[picked][unpicked] = res%mod;
        return res;
    }
}