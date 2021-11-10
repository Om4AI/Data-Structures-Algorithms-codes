class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        
//         Create array
        int arr[] = new int[n];
        for (int i=0; i<n; i++)arr[i] = i+1;
        
        backtrack(arr,0,k,res,new ArrayList<>());
        return res;
    }
    
    public void backtrack(int[] arr,int index,int k,List<List<Integer>> res,List<Integer> list){
        
//         Base cases
        if(list.size()==k) res.add(new ArrayList<>(list));
        
        for(int i=index; i<arr.length; i++){
            list.add(arr[i]);
            backtrack(arr,i+1,k,res,list);
            list.remove(list.size()-1);
        }
    }
}
