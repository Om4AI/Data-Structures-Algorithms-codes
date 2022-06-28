public class Solution {
    public String solve(String s){
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isLowerCase(c)) sb.append(Character.toUpperCase(c));
            else sb.append(Character.toLowerCase(c));
        }
        return sb.toString();
    }
}
