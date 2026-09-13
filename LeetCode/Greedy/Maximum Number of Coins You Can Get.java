class Solution {
    public int maxCoins(int[] piles){
        int n = piles.length, mul = piles.length/3, c=0, p = piles.length-2;
        Arrays.sort(piles);
        
        while(mul-->0){
            c+=piles[p];
            p-=2;
        }
        return c;
    }
}