class Solution {
    public long sumAndMultiply(int n){
        long nonzero_num = 0;
        int pow_counter = 0;
        int sum = 0;
        while (n > 0){
            int units = n % 10;
            n = n/10;
            if (units != 0){
                nonzero_num += Math.pow(10, pow_counter) * units;
                sum += units;
                pow_counter++;
            }
        }
        return sum * nonzero_num;
    }
}