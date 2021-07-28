import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        double count = Math.floor(nums.length/3);
        for (int i=0; i<nums.length; i++){
            if (map.containsKey(nums[i])){
                map.replace(nums[i], map.get(nums[i]), map.get(nums[i])+1);
            }
            else if (!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }
        }
        for (int i:map.keySet()){
            if (map.get(i)>count){
                list.add(i);
            }
        }
        return list;
    }
}
