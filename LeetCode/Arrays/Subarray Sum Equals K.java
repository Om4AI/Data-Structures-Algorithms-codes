class Solution {
    public int subarraySum(int[] arr, int k) {
        int sum = 0, c=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(sum, 1);
      
//       Loop to find sum till that index & check for target difference
        for (int i=0; i<arr.length; i++){
            sum+=arr[i];
            int key = sum-k;
            if(map.containsKey(key)){
                c+=map.get(key);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return c;
    }
}
