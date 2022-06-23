import java.util.*;

class Solution {
    public ArrayList<Integer> findSubstring(String s, List<String> B){
        String words[] = new String[B.size()];
        for(int i=0; i<B.size(); i++) words[i] = B.get(i);
        
        HashMap<String,Integer> map = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(String i: words) map.put(i, map.getOrDefault(i, 0)+1);

        // Create Sliding window
        StringBuffer sb = new StringBuffer();
        int k = words.length * words[0].length(), e = k, n= s.length(), st=0;
        
        // Total String length is less than total length of all words combined
        if(s.length() < k) return res;

        for(int i=0; i<k; i++) sb.append(s.charAt(i));
        if(isProperWindow(sb.toString(),map,words[0].length())) res.add(0);

        while(e<n){
            sb.deleteCharAt(0);
            sb.append(s.charAt(e));
            if(isProperWindow(sb.toString(),map,words[0].length())) res.add(st+1);
            e++;
            st++;
        }

        return res;
    }


    public static boolean isProperWindow(String s, HashMap<String,Integer> map, int len){
        // Split into words and check
        int p = len, st= 0;
        HashMap<String,Integer> tmap = new HashMap<>();

        while(p<=s.length()){
            String sub = s.substring(st, p);
            tmap.put(sub, tmap.getOrDefault(sub,0)+1);
            st+=len;
            p+=len;
        }

        return tmap.equals(map);
    }
}