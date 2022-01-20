class Solution {
    public int minEatingSpeed(int[] piles, int h){
        // Right - Maximum from the array of piles
        int left = 1, right = Integer.MIN_VALUE;
        // Find the maximum
        for(int n: piles) right = Math.max(right, n);

        // Actual loop
        while(left<right){
            int mid = left+((right-left)/2), c = 0;
            // Get hours required to finish the pile
            for (int pile: piles) c+= Math.ceil((double)pile/mid);

            // If c<=h - (Rate is workable but there might be a lesser possible)
            // If c>h - (Rate is too small thus search for a greater rate)
            if(c<=h){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        // Return the boundary rate (minimum)
        return left;
    }
}