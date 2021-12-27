class Solution {
    public int findComplement(int num) {
        String s = Integer.toBinaryString(num);
        int n = s.length();
//         Long used for the 2^31 case where Int range is exceeded
//         Again conversion to (int) for returning in that form
        return num^((int)(long)Math.pow(2,n)-1);
    }
}
