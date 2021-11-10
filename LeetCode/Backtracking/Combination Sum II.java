class Solution {
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        HashSet<List<Integer>> res = new HashSet();
        Arrays.sort(arr);
        
        backtrack(arr,0,target,new ArrayList(),res);
        return new ArrayList(res);
    }
    
    public void backtrack(int[] arr,int index,int target,List<Integer> list,HashSet<List<Integer>> res){
        if(target<0)return;
        if (target==0){
            res.add(new ArrayList(list));
        }
        
        for(int i=index; i<arr.length; i++){
            
//          Remove duplicates from the sets generated
            if(i>index && arr[i]==arr[i-1])continue;
            
            list.add(arr[i]);
            backtrack(arr,i+1,target-arr[i],list,res);
            list.remove(list.size()-1);
        }
    }
}
