// Memoization Approach - Top-Down DP (Memory Error)

import java.util.*;
class Solution {
    static int[][] t;
    public int maxProfit(int[] arr) {
        List<Integer> l = new ArrayList<>();
        for(int i: arr)l.add(i);
        int n = arr.length, mp = Collections.max(l);
        t = new int[n+1][mp+2];

        // Initialization
        for (int i=0; i<n+1; i++){
            Arrays.fill(t[i], -1);
        }
        return solve(arr,n,mp+1,mp);
    }

    public static int solve(int[] arr, int n, int price, int mp){
        int len = arr.length;
        // Base condition
        if(n==1){
            if(price<mp+1)return (arr[len-1]-price<0)? 0:arr[len-1]-price;
            else return 0;
        }

        if(price<mp+1){
            if(t[n][price]!=-1) return t[n][price];
        }


        int max = Integer.MIN_VALUE;
        if(price==mp+1){
            max = Math.max((solve(arr,n-1,arr[len-n],mp)), solve(arr,n-1,price,mp));
        }else if(price<mp+1){
            // Sell or skip
            int skip = solve(arr,n-1,price,mp);
            int sell = arr[len-n]-price;
            sell+= Math.max(solve(arr,n-1,arr[len-n],mp), solve(arr,n-1,mp+1,mp));
            max = Math.max(sell, skip);
        }
        return max;
    }
}

// DP Accepted Approach
class Solution {
    public int maxProfit(int[] arr) {
        int n = arr.length, maxProfit = 0;
        
        for(int i=1; i<n; i++){
	// Max ( Profit till yesterday, Profit till yesterday+ If I purchase yesterday & sell today) 
	// This means if we get a profit from yesterday to today, we take it else in case of loss
	// we reject it and continue
            maxProfit = Math.max(maxProfit, (maxProfit+arr[i]-arr[i-1]));
        }
        return maxProfit;
    }
}
