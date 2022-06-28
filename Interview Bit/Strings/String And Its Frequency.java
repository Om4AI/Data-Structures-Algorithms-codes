public class Solution {
    public String solve(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        HashSet<Character> set = new HashSet<>();
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(!set.contains(c)){
                sb.append(c);
                sb.append(String.valueOf(map.get(c)));
                set.add(c);
            }
        }
        return sb.toString();
    }
}
