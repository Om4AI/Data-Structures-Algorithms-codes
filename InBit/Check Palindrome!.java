public class Solution {
    public int solve(String s){
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        int odd =0;
        for(char k:map.keySet()){
            if((map.get(k))%2!=0) odd++;
        }
        if(odd>1) return 0;
        return 1;
    }
}
