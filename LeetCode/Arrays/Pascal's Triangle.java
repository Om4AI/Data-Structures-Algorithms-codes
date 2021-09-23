import java.util.*;
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> t = new ArrayList<>();
        t.add(1);
        res.add(t);
        numRows -=1;
        int p = 0;
        while (numRows>0){
            List<Integer> l = new ArrayList<>();
            List<Integer> prev = res.get(p);
            if (res.get(p).size()==0){
                l.add(1);
                l.add(1);
                res.add(l);
                p++;
            }else{
                l.add(1);
                for (int i=0; i<prev.size()-1; i++){
                    l.add(prev.get(i)+prev.get(i+1));
                }
                l.add(1);
                p++;
            }
            res.add(l);
            numRows--;
        }
        return res;
    }
}
