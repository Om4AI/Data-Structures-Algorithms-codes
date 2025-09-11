import java.util.*;
class Solution {
    public String reverseVowels(String s) {
        ArrayList<Integer> idx = new ArrayList<>();
        ArrayList<Character> arr = new ArrayList<>();
        int n = s.length();
        for (int i=0; i<n; i++){
            char c = s.charAt(i);
            c = Character.toLowerCase(c);
            if (c=='a' || c=='e' || c=='i'|| c=='o' || c=='u'){
                arr.add(s.charAt(i));
                idx.add(i);
            }
        }

        int idx_size = idx.size();
        StringBuffer sb = new StringBuffer(s);
        for (int i=0; i<idx_size; i++){
            sb.setCharAt(idx.get(i), arr.get(idx_size-i-1));
        }
        return sb.toString();
    }
}
