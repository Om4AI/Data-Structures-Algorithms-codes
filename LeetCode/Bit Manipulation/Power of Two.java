class Solution {
    public boolean isPowerOfTwo(int n) {
//         Check integer
        return (n>0 && Integer.bitCount(n)==1);
    }
}
