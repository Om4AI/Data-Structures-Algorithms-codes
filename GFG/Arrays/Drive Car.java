class Solution {
    public static long required(long a[], long n, long k) {
        long c = k, res =0;
        for(long i: a){
            if(c<i){
                res+=(i-c);
                c = i;
            }
        }
        return (res==0)?-1: res;
    }
}