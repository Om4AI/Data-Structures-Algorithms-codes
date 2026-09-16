class Solution {
    static int solve(int bt[]) {
        Arrays.sort(bt);
        int runningSum = 0, totalSum = 0, n = bt.length;
        for (int i=0; i<n; i++){
            totalSum += runningSum;
            runningSum += bt[i];
        }
        return totalSum/n;
    }
}
