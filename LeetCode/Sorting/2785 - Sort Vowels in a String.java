import java.util.*;

class Solution {
    public String sortVowels(String s){
        int n = s.length();
        int p = 0;
        ArrayList<Character> arr = new ArrayList<>();
        ArrayList<Integer> idx = new ArrayList<>();

        for (int i=0; i<n; i++){
            char c = s.charAt(i);
            c = Character.toLowerCase(c);
            if (c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
                arr.add(s.charAt(i));
                idx.add(i);
                p++;
            }
        }

        Collections.sort(arr);
        StringBuffer sb = new StringBuffer(s);
        for (int i=0; i<idx.size() ; i++){
            sb.setCharAt(idx.get(i), arr.get(i));
        }
        return sb.toString();
    }
}
