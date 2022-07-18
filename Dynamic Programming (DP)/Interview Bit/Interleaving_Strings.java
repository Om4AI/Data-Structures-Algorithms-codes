import java.util.*;

public class Solution{
    public static String A;
    public static String B;
    public static String C;
    public static int isInterleave(String A1, String B1, String C1){
        A = A1;
        B = B1;
        C = C1;

        // Basic condition
        if(C.length()!=(A.length()+B.length())) return 0;
        HashMap<String,Boolean> map = new HashMap<>();

        return isInter(0,0,0,map)?1:0; 
    }

    public static boolean isInter(int a, int b, int c, HashMap<String,Boolean> map){
        // Create key
        StringBuffer sb = new StringBuffer(String.valueOf(a));
        sb.append(" ");
        sb.append(String.valueOf(b));
        sb.append(" ");
        sb.append(String.valueOf(c));
        String k = sb.toString();

        // Base condition
        int cl = C.length(), al = A.length(), bl = B.length();
        if(c==cl && a==al && b==bl){
            map.put(k,true);
            return true;
        }
        else if(a==al){
            if((B.substring(b,bl).equals(C.substring(c,cl)))){
                map.put(k,true);
                return true;
            }else{
                map.put(k,false);
                return false;
            }
            
        }
        else if(b==bl){
            if(A.substring(a,al).equals(C.substring(c,cl))){
                map.put(k,true);
                return true;
            }else{
                map.put(k,false);
                return false;
            }
            
        }
        else if(c==cl && (a<al || b<bl)){
            map.put(k,false);
            return false;
        }

        // Memoization check
        if(map.containsKey(k)) return map.get(k);


        // General cases
        char ac = A.charAt(a), bc = B.charAt(b), cc = C.charAt(c);

        if(ac==cc && bc!=cc) map.put(k, isInter(a+1,b,c+1,map));
        else if(bc==cc && ac!=cc) map.put(k, isInter(a,b+1,c+1,map));
        else if(ac!=cc && bc!=cc) map.put(k, false);
        else{
            boolean ans = (isInter(a+1,b,c+1,map) || isInter(a,b+1,c+1,map));
            map.put(k, ans);
        }
        return map.get(k);
    }
}
