class Solution {
    public int maxScoreSightseeingPair(int[] arr) {
        // Initialize: max - The result which has the values of the expressions
        //             tempmax - The maximum value of arr[i]+i till the current j
        // Expression - (arr[i]+i) + (arr[j]-j)
        int max = Integer.MIN_VALUE, tempmax = arr[0];
        
        // Find the maximum arr[i]+i till the current j for every j
        for(int j=1; j<arr.length; j++){
            // Expression value (Maximum of arr[i]+i till (j-1)th index)
            int t = arr[j]-j+tempmax;
            max = Math.max(t,max);
            // Modify (arr[i]+i) maximum
            tempmax = Math.max(tempmax, arr[j]+j);
        }
        return max;
    }
}