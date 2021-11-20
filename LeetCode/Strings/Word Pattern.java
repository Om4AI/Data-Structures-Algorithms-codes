class Solution {
    public boolean wordPattern(String p, String s){
        String words[] = s.split(" ");
        
        if(words.length!=p.length()) return false;
        HashSet<String> set = new HashSet<>();
        HashMap<Character, String> map = new HashMap<>();
        
        for (int i=0; i<p.length(); i++){
            char c = p.charAt(i);
            if(map.containsKey(c)){
                if(!map.get(c).equals(words[i])) return false;
                else continue;
            }else if(!map.containsKey(c) && set.contains(words[i])){
                return false;
            }else{
                map.put(c, words[i]);
                set.add(words[i]);
            }
        }
        return true;
    }
}
