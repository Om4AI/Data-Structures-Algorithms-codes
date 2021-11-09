class Solution {
    public List<String> find_permutation(String S) {
        List<String> res = new ArrayList<>();
        List<String> l = new ArrayList<>();
        for (char c: S.toCharArray()) l.add(String.valueOf(c));
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<S.length(); i++){
            backtrack(res,l,sb,i,S.length());
        }
        Collections.sort(res);
        return res;
    }
    
    public void backtrack(List<String> res, List<String> l,StringBuffer sb, int index, int n){
        sb.append(l.get(index));
        if (sb.length()==n){
            res.add(new String(sb.toString()));
        }
        
        // recursive call to get all permutations
        List<String> c = new ArrayList<>(l);
        c.remove(index);
        for (int i=0; i<c.size(); i++) backtrack(res,c,sb,i,n);
        
        // Backtrack by deleting the last character
        sb.deleteCharAt(sb.length()-1);
    }
}
