class Solution {
    public int getSum(int a, int b) {
        if(b==0) return a;
        
//         Using Adder formulas
        int sum = a^b;
//         Find carry and shift to left 
        int carry = (a&b)<<1;
        return getSum(sum, carry);
    }
}
