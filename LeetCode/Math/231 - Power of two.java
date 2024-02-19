class Solution {
    public boolean isPowerOfTwo(int n) {
        return (Integer.bitCount(n)==1 && n>0) ? true:false;
    }
}