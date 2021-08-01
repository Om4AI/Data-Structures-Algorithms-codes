class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> list = new ArrayList();
        int n = arr.length;
        for (int i=0; i<=arr.length-3; i++){
//             Same result skip
            if (i>0 && arr[i-1]==arr[i]) continue;
//             Two pointers
            int j=i+1, k=n-1;
            int target = -arr[i];
            while (j < k){
                if (arr[j]+arr[k] == target){
                    list.add(Arrays.asList(arr[i], arr[j], arr[k]));
                    j++;
                    k--;
                    while (j<k && arr[j]==arr[j-1]){j++;}   // Same result
                    while (j<k && arr[k]==arr[k+1]){k--;}   // Same result
                }else if (arr[j]+arr[k] > target){
                    k--;
                }else{j++;}
            }
        }
        return list;
    }
}
