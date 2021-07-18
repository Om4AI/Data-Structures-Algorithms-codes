// HashMap

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            Integer prev_pos = map.put(nums[i], i);
            if (prev_pos != null && Math.abs(prev_pos - i)<=k) return true;
        }
        return false;
    }
}
