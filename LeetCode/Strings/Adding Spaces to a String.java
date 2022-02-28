class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuffer sb = new StringBuffer();
        int n = spaces.length, p = 0, i=0, len = s.length();
        
        while(i<len){
            if(p<n && i==spaces[p]){
                sb.append(" ");
                sb.append(s.charAt(i));
                p++;
            }else sb.append(s.charAt(i));
            i++;
        }
        return sb.toString();
    }
}
