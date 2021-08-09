// Code by @Om

class Solution {

    static char[] get_ch_array(String s){
        char c[] = new char[s.length()];
        StringBuffer sb = new StringBuffer(s);
        s = sb.reverse().toString();
        // Construct char[] array
        for (int i=0; i<s.length(); i++){
            c[i] = s.charAt(i);
        }
        return c;
    }


    public String addStrings(String num1, String num2) {
        // Small string length
        int n = num1.length() < num2.length() ? num1.length():num2.length();
        // Reverse strings & convert to char[] arrays
        char n1[] = get_ch_array(num1);
        char n2[] = get_ch_array(num2);

        Integer carry = 0;
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<n; i++){
            int sum = Character.getNumericValue(n1[i]) + Character.getNumericValue(n2[i]) + carry;
            carry = 0;
            String rem = Integer.toString(sum%10);
            sb.append(rem);
            carry += sum/10;
        }
        int i = n;
        // Add the remaining characters
        while (i<n1.length){
            int sum = Character.getNumericValue(n1[i]) + carry;
            carry = 0;
            String rem = Integer.toString(sum%10);
            sb.append(rem);
            carry += sum/10;
            i++;
        }
        while (i<n2.length){
            int sum = Character.getNumericValue(n2[i]) + carry;
            carry = 0;
            String rem = Integer.toString(sum%10);
            sb.append(rem);
            carry += sum/10;
            i++;
        }
        if (carry>0) sb.append(carry);
        return sb.reverse().toString();
    }
}
