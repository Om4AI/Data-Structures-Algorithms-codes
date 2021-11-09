class Solution {
    public String getPermutation(int n, int k) {
        List<String> l = new ArrayList<>();
        List<String> res = new ArrayList<>();
        for (int i=1; i<=n; i++) l.add(String.valueOf(i));
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<n; i++){
            if (res.size()<=k-1){
                backtrack(l,res,sb,i,n);
            }else break;
        }
        return res.get(k-1);
    }
    
    public void backtrack(List<String> l,List<String> res,StringBuffer sb,int index,int n){
        sb.append(l.get(index));
        if (sb.length()==n){
            res.add(new String(sb.toString()));
        }
        List<String> copy = new ArrayList(l);
        copy.remove(index);
        
//         Recursive call
        for (int i=0; i<copy.size(); i++){
            backtrack(copy, res, sb, i, n);
        }
//         Backtrack
        sb.deleteCharAt(sb.length()-1);  
    }
}
