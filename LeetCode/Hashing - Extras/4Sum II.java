class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4){
        HashMap<Integer, Integer> map = new HashMap<>();
        int c = 0;

        for(int n3: nums3){
            for (int n4: nums4){
                map.put(n3+n4, map.getOrDefault(n3+n4, 0)+1);
            }
        }

        // Actual loop for forming tuples
        for(int n1: nums1){
            for(int n2: nums2){
                c+= map.getOrDefault(-(n1+n2), 0);
            }
        }
        return c;
    }
}
