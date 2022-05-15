import java.util.*;
import java.lang.*;
public class Solution {
    public long solve(String s) {
        StringBuffer sb = new StringBuffer();
        long sum = 0;
        for(int i=0; i<s.length(); i++){
            Character c = s.charAt(i);
            if(!Character.isLetter(c)){
                sb.append(c);
            }else{
                if(sb.length()==0) sum+=0;
                else{
                    sum+=Integer.parseInt(sb.toString());
                    sb = new StringBuffer();
                }
            }
        }
        if(sb.length()==0) sum+=0;
        else{
            sum+=Integer.parseInt(sb.toString());
            sb = new StringBuffer();
        }
        return sum;
    }
}
