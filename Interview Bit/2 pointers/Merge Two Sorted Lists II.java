public class Solution {
	public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        List<Integer> res = new ArrayList<>();
        
        int i = 0, j = 0, m = a.size(), n = b.size();
        
        while(i<m && j<n){
            if(a.get(i)<=b.get(j)){
                res.add(a.get(i));
                i++;
            }else if(b.get(j)<a.get(i)){
                res.add(b.get(j));
                j++;
            }
        }
        
        while(i<m){
            res.add(a.get(i));
            i++;
        }
        
        while(j<n){
            res.add(b.get(j));
            j++;
        }
        
        for(int i1=0; i1<m; i1++) a.set(i1, res.get(i1));
        for(int i1=m; i1<m+n; i1++) a.add(res.get(i1));
	}
}
