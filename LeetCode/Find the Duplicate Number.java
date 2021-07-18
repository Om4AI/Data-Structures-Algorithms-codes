// Code using HashMap

class Solution {
    public int findDuplicate(int[] nums) {
        int res = 0;
        HashMap<Integer, String> map = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            String s = map.put(nums[i], String.valueOf(nums[i]));
            if (s != null) res = nums[i];
        }
        return res;
    }
}
