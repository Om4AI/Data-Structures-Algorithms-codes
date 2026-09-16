// Greedy solution - Make the maximum jump at each index
// Only case where this fails is when we have a zero in the array and we can't go past it
class Solution {
    public boolean canJump(int[] arr) {
        int maxIdx = 0, n = arr.length;
        for (int i=0; i<n; i++){
            // We can never reach this since the maxIndex we can reach has gone behind us
            if (i > maxIdx) return false;
            // Update maxIndex with the value which can be reached farthest
            // At every index we make the - GREEDY MAXIMUM JUMP to reach the farthest index
            maxIdx = Math.max(maxIdx, i+arr[i]);
        }
        // Since we reached here without returning false means we can reach the final index in the array as well
        return true;
    }
}