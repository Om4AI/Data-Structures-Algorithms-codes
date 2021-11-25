// Code by @Om
import java.util.*;
class Solution {
    public int findTheWinner(int n, int k) {
        int s = 0, c = n-1;
        List<Integer> l = new ArrayList<>();
        for (int i=0;i<n; i++){
            l.add(i+1);
        }
        while (c>0){
            int in= 0;
            if ((s+k)>l.size()){
                in = ((s+k)%l.size())-1;
            }else in = s+k - 1;

            in = (in==-1)?l.size()-1:in;
            l.remove(in);
            s = in;
            c-=1;
        }
        return l.get(0);
    }
}
