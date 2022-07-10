import java.util.*;

class Solution {
    public int minCostClimbingStairs(int[] cost){
        int t[] = new int[cost.length+1];
        Arrays.fill(t,-1);

        return Math.min(minCost(cost,0,t), minCost(cost,1,t));
    }

    public static int minCost(int[] cost, int index,int[] t){
        // Base case
        if(index>=cost.length) return t[cost.length] = 0;

        // Memoization check
        if(t[index]!=-1) return t[index];

        // General cases
        return t[index] = Math.min(cost[index]+minCost(cost,index+1,t),cost[index]+minCost(cost,index+2,t));
    }
}