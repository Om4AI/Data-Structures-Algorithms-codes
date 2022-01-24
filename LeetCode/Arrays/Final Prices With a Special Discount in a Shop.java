class Solution {
    public int[] finalPrices(int[] prices) {
        int n= prices.length;
        int res[] = new int[n];
        
        for(int i=0; i<n-1; i++){
            int f = 0;
            for(int j=i+1; j<n; j++){
                if(prices[j]<=prices[i]){
                    f = 1;
                    res[i] = prices[i] - prices[j];
                    break;
                }
            }
            if(f==0) res[i] = prices[i];
        }
        res[n-1] = prices[n-1];
        return res;
    }
}
