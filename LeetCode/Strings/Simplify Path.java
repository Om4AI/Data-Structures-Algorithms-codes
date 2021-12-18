import java.util.*;
class Solution {
    public String simplifyPath(String p) {
        p = p.replaceAll("/", " ");
        p = p.replaceAll("\\s+"," ").trim();
        p = p.replaceAll(" ","/");

        String arr[] = p.split("/");
        List<String> res = new ArrayList<>();

        for(int i=0; i<arr.length; i++){
            String s = arr[i];

            if(s.equals("..") && res.size()>0){
                res.remove(res.size()-1);
            }else if(s.equals(".") || (s.equals("..") && res.size()==0))continue;
            else{
                res.add(s);
            }
        }
        
        if(res.size()==0) return "/";
        StringBuffer sb = new StringBuffer("/");
        for(String str: res){
            sb.append(str);
            sb.append("/");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}