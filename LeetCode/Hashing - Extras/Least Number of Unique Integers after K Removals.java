class Solution {
    public static int findLeastNumOfUniqueInts(int[] arr, int m) {
        int n = arr.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        List<Integer> l = new ArrayList<>();
        for(int k:map.keySet()){
            l.add(map.get(k));
        }
        Collections.sort(l);
        int temp=0;
        for(int i=0; i<l.size(); i++){
            temp+=l.get(i);
            if(temp>m){
                return map.size()-i;
            }
        }
        return 0;
    }
}


