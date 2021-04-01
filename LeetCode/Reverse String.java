class Solution {
    public void reverseString(char[] s) {
        StringBuffer sb = new StringBuffer();
        for (char i:s){sb.append(i);}
        sb = sb.reverse();
        for (int j =0;j<s.length; j++){
            s[j] = sb.charAt(j);
        }
    }
}
