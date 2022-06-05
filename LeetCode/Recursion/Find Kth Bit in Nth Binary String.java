// -------------------- Recursive Approach ----------------------
class Solution {
    public char findKthBit(int n, int k) {
        return generateString(n).charAt(k-1);
    }
    
    public static String generateString(int n){
        // Base case
        if(n==1) return "0";
        
        StringBuffer sb = new StringBuffer();
        String s = generateString(n-1);
        sb.append(s);
        sb.append("1");
        
        // Reverse the S(n-1) string
        StringBuffer temp = new StringBuffer();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='0') temp.append('1');
            else temp.append('0');
        }
        sb.append(temp.reverse().toString());
        
        return sb.toString();
    }
}