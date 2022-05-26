public class Solution {
    public int solve(int a, int b, int c, int d){
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(a,map.getOrDefault(a,0)+1);
        map.put(b,map.getOrDefault(b,0)+1);
        map.put(d,map.getOrDefault(d,0)+1);
        map.put(c,map.getOrDefault(c,0)+1);

        if(map.size()==2){
            for(int k:map.keySet()){
                if(map.get(k)!=2) return 0;
            }
            return 1;
        }
        return 0;
    }
}
