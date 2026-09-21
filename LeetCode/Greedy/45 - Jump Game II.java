// Greedy solution - Start from an index and calculate the range where we can jump from that index
// Then keep increasing the range till we get the last index in that range & return jumps which we had tracked all the way

class Solution {
    public int jump(int[] arr) {
        int l = 0, r = 0, jumps = 0;
        while (r<arr.length-1){
            int farthest = 0;
            for (int i=l; i<=r; i++){
                farthest = Math.max(farthest, i+arr[i]);
            }
            l = r+1;
            r = farthest;
            jumps++;
        }
        return jumps;
    }
}