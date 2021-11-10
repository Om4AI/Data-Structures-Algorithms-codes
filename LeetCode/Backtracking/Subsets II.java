class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        HashSet<List<Integer>> res = new HashSet<>();
        for(int i=0; i<=nums.length; i++){
            backtrack(i,nums,0,res,new ArrayList<>());
        }
        List<List<Integer>> r = new ArrayList<>(res);
        for (int i=0; i<r.size(); i++){
            Collections.sort(r.get(i));
        }
        HashSet<List<Integer>> set = new HashSet(r);
        return new ArrayList<>(set);
    }
    
    public void backtrack(int k,int[] arr,int index,HashSet<List<Integer>> res,List<Integer> list){
        if(list.size()==k) res.add(new ArrayList<>(list));
        
        for(int i=index; i<arr.length; i++){
            list.add(arr[i]);
            backtrack(k,arr,i+1,res,list);
            list.remove(list.size()-1);
        }
    }
}
