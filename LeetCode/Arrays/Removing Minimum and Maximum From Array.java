// Initial Try (Not Accepted)

class Solution {
    public int minimumDeletions(int[] arr){
        List<Integer> l = new ArrayList<>();
        for (int i: arr)l.add(i);
        
        int min = Collections.min(l), max = Collections.max(l);
        int min_indx = l.indexOf(min);
        int n = l.size(), dels = 0;
        if(n==1) return 1;
        
        // Remove minimum
        int sp = (min_indx+1)<=(n-min_indx) ? 0:1;
        int els_remove =  (min_indx+1)<=(n-min_indx) ? (min_indx+1):(n-min_indx);
        if(sp==0){
            while(els_remove>0){
                l.remove(sp);
                dels++;
                els_remove--;
            }
        }else{
            while(els_remove>0){
                l.remove(l.size()-1);
                dels++;
                els_remove--;
            }
        }

        // Remove maximum
        if(!l.contains(max)) return dels;
        int max_indx = l.indexOf(max);
        sp = (max_indx+1)<=n-max_indx ? 0:l.size()-1;
        els_remove =  (max_indx+1)<=(n-max_indx) ? (max_indx+1):(l.size()-max_indx);
        if(sp==0){
            while(els_remove>0){
                l.remove(sp);
                dels++;
                els_remove--;
            }
        }else{
            while(els_remove>0){
                l.remove(l.size()-1);
                dels++;
                els_remove--;
            }
        }
        return dels;
    }
}
