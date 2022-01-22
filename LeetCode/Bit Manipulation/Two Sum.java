// Brute Force Approach

class Solution {
    public int[] twoSum(int[] arr, int target) {
        
        int res[] = new int[2];
        for(int i=0; i<arr.length; i++){
            int el = target - arr[i];
            for (int j=i+1; j<arr.length; j++){
                if (arr[j]==el){
                    res[0] = i;
                    res[1] = j;
                    break;
                }
            }
        }
        return res;
    }
}

// Better time complexity (HashMap)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int res[] = new int[2];
        HashMap<Integer, Integer> map = new HashMap();
        for (int i=0; i<nums.length; i++){
            if (map.containsKey(target- nums[i])){
                res[0] = map.get(target- nums[i]);
                res[1] = i;
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
