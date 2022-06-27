public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> list){
        int n = list.size();
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<Integer> res1 = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(list.get(i)==0){
                res.add(0);
            }else res1.add(list.get(i));
        }
        res1.addAll(res);
        return res1;
    }
}
