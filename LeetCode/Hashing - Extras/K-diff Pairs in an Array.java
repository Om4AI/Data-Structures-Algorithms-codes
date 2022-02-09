class Solution {
    public int findPairs(int[] nums, int k){
        int c = 0;
        // Case with k = 0
        if(k==0){
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i:nums){
                map.put(i, map.getOrDefault(i, 0)+1);
            }
            for(int key: map.keySet()) if(map.get(key)>=2) c++;
            return c;
        }
        // Main case
        else{
            HashSet<Integer> set = new HashSet<>();
            for (int num: nums) set.add(num);

            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i: set){
                map.put((i+k), map.getOrDefault((i+k), 0)+1);
                map.put((i-k), map.getOrDefault((i-k), 0)+1);
            }
            // Iteration for checking pairs
            for(int n: set){
                if(map.containsKey(n)) c+=map.get(n);
            }
        }
        return c/2;
    }
}