// Collections Q - Java
public class Solution {
    public String solve(String s){
        StringBuffer sb = new StringBuffer();
        List<Character> l = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(!map.containsKey(c)){
                l.add(c);
                map.put(c,1);
            }else if(map.containsKey(c) && l.contains(c)){
                int index = l.indexOf(c);
                l.remove(index);
            }

            if(l.size()!=0) sb.append(l.get(0));
            else sb.append('#');
        }
        return sb.toString();
    }
}
