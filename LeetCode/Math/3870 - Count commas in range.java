// All numbers from 1000 till 10^5 which is the constraint will have 1 comma each
// 1,000 -> 100,000
class Solution {
    public int countCommas(int n) {
        // Number less than 1000
        if (n<1000) return 0;
        else{
            return n-999;
        }
    }
}