public class Solution {
    public int maximumGap(final int[] arr){
        Arrays.sort(arr);
        int diff = 0;
        
        for(int i=0; i<arr.length-1; i++){
            diff = Math.max(arr[i+1]-arr[i], diff);
        }
        return diff;
    }
}
