public class Solution {
    public int repeatedNumber(final List<Integer> l){
        HashMap<Integer,Integer> map = new HashMap<>();
        int n= l.size();

        for(int i:l) map.put(i,map.getOrDefault(i, 0)+1);
        for(int k:map.keySet()){
            if(map.get(k)>(n/3)) return k;
        }
        return -1;
	}
}
