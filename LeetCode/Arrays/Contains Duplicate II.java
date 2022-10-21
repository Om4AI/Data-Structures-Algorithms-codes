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


// Approach II
class Solution {
    public boolean containsNearbyDuplicate(int[] arr, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        int n = arr.length;
        for(int i=0; i<n; i++){
            int el = arr[i];
            if(!map.containsKey(el)){
                map.put(el, i+k);
            }else{
                if(i<=map.get(el)) return true;
                else{
                    map.put(el, i+k);
                }
            }
        }
        return false;
    }
}
