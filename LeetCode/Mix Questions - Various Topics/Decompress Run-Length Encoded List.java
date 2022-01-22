class Solution {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<nums.length-1; i+=2){
            int f = nums[i], n = nums[i+1];
            for (int j=0; j<f; j++){
                list.add(n);
            }
        }
        int arr[] = new int[list.size()];
        for (int i=0; i<arr.length; i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
}
