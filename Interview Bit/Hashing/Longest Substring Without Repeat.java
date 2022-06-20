public class Solution {
    public int lengthOfLongestSubstring(String s){
        HashSet<Character> set = new HashSet<>();
        
        int i=0, j=0, res=0;
        while(j<s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                res = Math.max(res, set.size());
            }else{
                set.remove(s.charAt(i));
                i++;
            }
        }
        return res;
    }
}
