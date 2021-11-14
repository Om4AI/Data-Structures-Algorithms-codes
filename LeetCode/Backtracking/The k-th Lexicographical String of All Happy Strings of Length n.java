class Solution {
    public String getHappyString(int n, int k) {
        List<String> arr = new ArrayList<>();
        arr.add("a");
        arr.add("b");
        arr.add("c");
        List<String> res = new ArrayList<>();
        backtrack(res,arr,n,0,new StringBuffer());
        if(k<=res.size()) return res.get(k-1);
        else return new String();
    }
    
    public void backtrack(List<String> res,List<String> larr,int n, int index,StringBuffer sb){
//         Base case
        if(sb.length()==n){
            res.add(sb.toString());
            return;
        }
        
//         Backtrack & Recursive call
        for(int i=0; i<larr.size(); i++){
            if(sb.length()>0 && sb.charAt(sb.length()-1)==larr.get(i).charAt(0)) continue;
            else sb.append(larr.get(i));
            
            
            backtrack(res,larr,n,0,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
