class Solution {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        int p =0;
        int res[] = new int[2];
        for (int k: map.keySet()){
            if(map.get(k)==1){
                res[p] = k;
                p++;
            }
        }
        return res;
    }
}
