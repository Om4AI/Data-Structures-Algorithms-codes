class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int res[] = new int[nums.length];
//         Arraylist to get smaller nums count
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<nums.length; i++){list.add(nums[i]);}
        Collections.sort(list);
        
        for (int i=0; i<nums.length; i++){
            res[i] = list.indexOf(nums[i]);
        }
        return res;
    }
}
