class Solution {
    public int singleNonDuplicate(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i=0; i<arr.length; i++){
            int n = arr[i];
            map.put(n, map.getOrDefault(n,0)+1);
        }
        
        for (int k:map.keySet())
            if(map.get(k)==1) return k;
        return 1;
    }
}
