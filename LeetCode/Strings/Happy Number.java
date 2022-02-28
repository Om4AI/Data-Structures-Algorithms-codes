import java.util.*;
class Solution {
    public boolean isHappy(int n){
        HashSet<String> set = new HashSet<>();

        String val = Integer.toString(n);
        set.add(val);
        while(!val.equals("1")){
            val = get_square_sum(val);
            if(set.contains(val)){
                return false;
            }
            else set.add(val);
        }
        return true;
    }

    public static String get_square_sum(String s){
        int res = 0;
        for(int i=0; i<s.length(); i++){
            res+= Math.pow(Character.getNumericValue(s.charAt(i)), 2);
        }
        return String.valueOf(res);
    }
}