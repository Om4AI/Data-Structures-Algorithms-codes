class Solution {
    public int minMergedInteger(int[] arr) {
        int min = Integer.MAX_VALUE, n = arr.length;
        for (int i=0; i<n-1; i+=2){
            int curr = arr[i], next = arr[i+1];
            if (next < 10){
                curr = curr * 10 + next;
            }else if (next < 100) curr = curr * 100 + next;
            else if (next < 1000) curr = curr * 1000 + next;
            else curr = curr * 10000 + next;

            min = Math.min(curr, min);
        }
        return min;
    }
}