// SOLUTION 1
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










// SOLUTION 2 - Subset Size Approach
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int n, k;
    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
//         k - Length of the subset
        for (k=0; k<n+1; k++){
            backtrack(0,new ArrayList<Integer>(),nums);
        }
        return res;
    }
    
    public void backtrack(int first, List<Integer> curr, int[] arr){
//         Current list size is equal to subset size
        if (curr.size()==k){
            res.add(new ArrayList<>(curr));
            return;
        }
        
        for (int i=first; i<n; i++){
//             Add elements to the surrent list
            curr.add(arr[i]);
            
//             Keep adding the further elements to the list
            backtrack(i+1, curr, arr);
            
//             After completing single branch, backtrack to the previous branch
            curr.remove(curr.size()-1);
        }
    }
}
