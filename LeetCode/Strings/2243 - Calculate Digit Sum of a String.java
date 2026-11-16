// Logic - Use a running pointer which counts till k and keeps adding the digits
// Then when it reaches the length of k, it resets & appends the sum to a stringbuffer
// Finally it replaces the string with the sum & keeps going until (string doesn't become <= k)

class Solution {
    public String digitSum(String s, int k) {
        StringBuffer sb = new StringBuffer();
        while (s.length() > k){
            int sum = 0, p = 0, counter = 1;
            // Single traverse of the number
            while (p < s.length()){
                if (counter<k){
                    sum += Character.getNumericValue(s.charAt(p));
                    counter++;
                }else if (counter==k){
                    sum += Character.getNumericValue(s.charAt(p));
                    sb.append(String.valueOf(sum));
                    counter = 1;
                    sum=0;
                }
                p++;
            }
            if (s.length()%k!=0) sb.append(String.valueOf(sum));
            s = sb.toString();
            sb.setLength(0);
        }
        return s;
    }
}