class Solution {
    public List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> larr = new ArrayList<>();
        for(int n:arr)larr.add(n);
        backtrack(res,new ArrayList<>(), 0, larr, larr.size());
        return res;
    }
    
    public void backtrack(List<List<Integer>> res,ArrayList<Integer> list,int index,List<Integer> larr, int k){
        if(list.size()==k){
            res.add(new ArrayList<>(list));
            return;
        }
        
        for (int i=index; i<larr.size(); i++){
            list.add(larr.get(i));
            
            List<Integer> copy = new ArrayList<>(larr);
            copy.remove(i);
            
            backtrack(res,list,0,copy,k);
            list.remove(list.size()-1);
        }
    }
}
