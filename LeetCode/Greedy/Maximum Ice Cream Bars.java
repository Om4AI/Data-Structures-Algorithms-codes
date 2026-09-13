class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int n = costs.length,c=0;
        for(int i=0; i<n; i++){
            if(costs[i]<=coins){
                c++;
                coins-=costs[i];
            }else return c;
        }
        return c;
    }
}