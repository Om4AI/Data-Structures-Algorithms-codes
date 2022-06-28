public class Solution {
    public int[] solve(String s){
        int res[] = new int[26];
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            res[(int)c-97]++;
        }
        return res;
    }
}
