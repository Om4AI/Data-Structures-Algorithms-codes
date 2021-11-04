class Solution {
    public List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        get_subsets(arr,0,curr,ans);
        return ans;
    }
    
    public void get_subsets(int[] arr, int i, List<Integer> curr, List<List<Integer>> ans){
        if (i==arr.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        
//         Add new elements to temp list
        curr.add(arr[i]);
//         Modify lists by further exploration
        get_subsets(arr, i+1, curr, ans);
//         Backtrack from the last element
        curr.remove(curr.size()-1);
//         Modify lists again with other track
        get_subsets(arr, i+1, curr, ans);
    }
}
