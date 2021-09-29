class Solution {
    public int[] twoSum(int[] arr, int target) {
        int n = arr.length;
        int s=0, e = n-1;
        while(s<n && s<e){
            int sum = arr[s]+arr[e];
            if (sum==target) break;
            else if (sum < target) s++;
            else if (sum>target) e--;
        }
        return new int[] {s+1, e+1};
    }
}
