public class Solution {
    public String serialize(String[] arr){
        StringBuffer sb = new StringBuffer();
        for(String s: arr){
            sb.append(s);
            sb.append(String.valueOf(s.length()));
            sb.append("~");
        }
        return sb.toString();
    }
}
