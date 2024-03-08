class Solution {
    public int maxFrequencyElements(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max_occ = Integer.MIN_VALUE;

        for (int i=0; i<arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
            int curr_occ = map.get(arr[i]);
            max_occ = Math.max(max_occ, curr_occ);
        }

        int res = 0;
        for (int k: map.keySet()){
            if (map.get(k)==max_occ) res+=max_occ;
        }
        return res;
    }
}
