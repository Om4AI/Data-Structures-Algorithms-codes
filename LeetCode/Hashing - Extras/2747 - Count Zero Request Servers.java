import java.util.*;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        HashMap<Integer, HashSet> map = new HashMap<>();
        for (int i=0; i<logs.length; i++){
            int time = logs[i][1], server = logs[i][0];
            HashSet<Integer> temp = map.getOrDefault(time, new HashSet<>());
            temp.add(server);
            map.put(time, temp);
        }

        int res[] = new int[queries.length];
        for (int i=0; i<queries.length; i++){
            int num = queries[i];
            HashSet<Integer> currSet = new HashSet<>();
            for (int j=num-x; j<num+1; j++){
                // Go to the map and get the servers pinged at that time
                if (map.get(j)!=null){
                    currSet.addAll(map.get(j));
                }
            }
            res[i] = n - currSet.size();
        }
        return res;
    }
}