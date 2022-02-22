class Solution {
    public int titleToNumber(String s) {
        int res = 0, n = s.length();
        // Strings before this number of digits
        for(int i=1; i<n; i++){
            res+=Math.pow(26,i);
        }
        
        // Strings having same length but before
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            int rem = (int)c-65, mul = n-i-1;
            res+=rem*Math.pow(26,mul);
        }
        return res+1;
    }
}
