class Solution {
    public int maxProfit(int[] prices) {
        int max_prof = 0, min_stock_price = Integer.MAX_VALUE;
        for (int price:prices){
            if (price < min_stock_price){min_stock_price = price;}
            else if(price - min_stock_price > max_prof){max_prof = price - min_stock_price;}
        }
        return max_prof;
    }
}
