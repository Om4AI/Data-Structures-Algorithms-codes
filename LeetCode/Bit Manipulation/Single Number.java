class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
//         0 XOR num = num
        
//         n XOR n = 0; thus XOR of all cancels all duplicates
        for(int n: nums) res = res^n;
        return res;
    }
}
