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
