// Using HashSet
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        HashSet<Integer> set= new HashSet<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<nums.length; i++){
            int pl = set.size();
            set.add(nums[i]);
            if(set.size()==pl) list.add(nums[i]);
        }
        return list;
    }
}

// Using HashMap
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        List<Integer> list = new ArrayList<>();
        for(int k: map.keySet()){
            if(map.get(k)==2) list.add(k);
        }
        return list;
    }
}
