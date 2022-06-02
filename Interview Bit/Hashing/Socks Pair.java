public class Solution {
    public int solve(int[] A){
        HashMap<Integer, Integer> map = new HashMap<>();
        int c = 0;

        for(int i: A){
            map.put(i, map.getOrDefault(i,0)+1);
        }

        for(int k: map.keySet()){
            int occ = map.get(k);
            if(occ>=2){
                c+=occ/2;
            }
        }
        return c;
    }
}
