class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int n = cost.length;
        int res = 0;

        for (int i=n-1; i>=0; i-=3){
            res += cost[i];
            if (i==0) break;
            res += cost[i-1];
        }
        return res;
    }
}
