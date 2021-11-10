import java.util.*;
class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(arr,0,target,res,new ArrayList<>());
        return res;
    }

    private void backtrack(int[] arr,int index, int target, List<List<Integer>> res, List<Integer> list){

        // Base Cases
        if (target<0) return;
        else if (target==0){
            res.add(new ArrayList<>(list));
        }

        // Prevent different order but same elements sets
        for (int i=index; i<arr.length; i++){
            list.add(arr[i]);
            backtrack(arr,i,target-arr[i],res,list);
            list.remove(list.size()-1);
        }
    }
}
