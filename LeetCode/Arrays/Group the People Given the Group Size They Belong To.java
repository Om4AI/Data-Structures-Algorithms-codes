class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int n = groupSizes.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();

        for(int i=0; i<n; i++){
            int grp_size = groupSizes[i];
            // If list doesn't exist
            if(!map.containsKey(grp_size)){
                map.put(grp_size, new ArrayList<>());
            }

            // Get list
            List<Integer> list = map.get(grp_size);
            // Add element into list
            if(list.size()<grp_size){
                list.add(i);
            }

            // List full then append to result and initialize new list in its place
            if(list.size()==grp_size){
                res.add(list);
                map.put(grp_size, new ArrayList<>());
            }
        }
        // Return result
        return res;
    }
}