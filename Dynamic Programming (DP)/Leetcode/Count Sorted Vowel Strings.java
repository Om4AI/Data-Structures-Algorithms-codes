import java.util.*;

class Solution {
    public static List<Character> v;
    public static HashMap<String,Integer> map;

    public int countVowelStrings(int n){
        v = new ArrayList<>();
        map = new HashMap<>();

        char vow[] = new char[]{'a','e','i','o','u'};
        for (char c: vow) v.add(c);

        return allvowStrings(n,'s');
    }

    public static int allvowStrings(int n, char prev){
        int index = (prev!='s')?v.indexOf(prev):0;
        StringBuffer sb = new StringBuffer(String.valueOf(n));
        sb.append(" ");
        sb.append(prev);
        String k = sb.toString();
        
        // Base case
        if(n==1){
            map.put(k,5-index);
            return map.get(k);
        }

        // Memoization check
        if(map.containsKey(k)) return map.get(k);

        // General case 
        int res = 0;
        for(int i=index; i<5; i++){
            res+= allvowStrings(n-1,v.get(i));
        }
        map.put(k,res);
        return map.get(k);
    }
}