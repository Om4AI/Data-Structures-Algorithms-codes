// Imp Note: Initialize the HashMap as a common DS instead of creating a new one at every count iteration

class FindSumPairs {
    List<Integer> l1 = new ArrayList<>();
    List<Integer> l2 = new ArrayList<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    public FindSumPairs(int[] nums1, int[] nums2) {
        for(int i: nums1) l1.add(i);
        for(int j: nums2) l2.add(j);
        for(int i: l2){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
    }
    
    public void add(int index, int val){
        int el = l2.get(index);
        map.put(el, map.get(el)-1);
        l2.set(index, el+val);
        map.put(el+val, map.getOrDefault((el+val), 0)+1);
    }
    
    public int count(int tot){
        int c = 0;
        for(int i=0; i<l1.size(); i++){
            int diff = tot-l1.get(i);
            if(map.containsKey(diff)){
                c+=map.get(diff);
            }
        }
        return c;
    }
}