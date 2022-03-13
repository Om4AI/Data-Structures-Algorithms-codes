public class Solution {
    public ArrayList<Integer> wave(ArrayList<Integer> l) {
        int n = l.size(), i=0, j=1;
        Collections.sort(l);
        ArrayList<Integer> res = new ArrayList<>();
        while(i<n && j<n){
            res.add(l.get(j));
            res.add(l.get(i));
            j+=2;
            i+=2;
        }
        if (i<n) res.add(l.get(i));
        else if (j<n) res.add(l.get(j));
        return res;
    }
}
