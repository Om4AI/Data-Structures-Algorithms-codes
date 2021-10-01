class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0, j=0, max = 0;
        HashSet<Character> set = new HashSet<>();
        while(j<s.length()){
//             New char
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                max=Math.max(set.size(), max);
            }else{   // Existing char
                set.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }
}
