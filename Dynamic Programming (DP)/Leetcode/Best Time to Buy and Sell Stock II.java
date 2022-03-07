// Memoization Approach - Top-Down DP

import java.util.*;
class Solution {
    static int[][] t;
    public int maxProfit(int[] arr) {
        List<Integer> l = new ArrayList<>();
        for(int i: arr)l.add(i);
        int n = arr.length, maxprice = Collections.max(l);
        t = new int[n+1][maxprice+1];

        // Initialization
        for (int i=0; i<n+1; i++){
            Arrays.fill(t[i], -1);
        }
        return solve(arr,n,-1);
    }

    public static int solve(int[] arr, int n, int price){
        int len = arr.length;
        // Base condition
        if(n==1){
            if(price>-1)return (arr[len-1]-price<0)? 0:arr[len-1]-price;
            else return 0;
        }

        if(price>-1){
            if(t[n][price]!=-1) return t[n][price];
        }


        int max = Integer.MIN_VALUE;
        if(price==-1){
            max = Math.max((solve(arr,n-1,arr[len-n])), solve(arr,n-1,price));
        }else if(price>-1){
            // Sell or skip
            int skip = solve(arr,n-1,price);
            int sell = arr[len-n]-price;
            sell+= Math.max(solve(arr,n-1,arr[len-n]), solve(arr,n-1,-1));
            max = Math.max(sell, skip);
        }
        if(price>-1) return t[n][price] = max;
        else return max;
    }
}
