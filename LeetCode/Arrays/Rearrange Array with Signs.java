class Solution {
    public int[] rearrangeArray(int[] arr){
        int n = arr.length;
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        
        for(int i: arr){
            if(i>0) pos.add(i);
            else neg.add(i);
        }
        int res[] = new int[n];
        int p = 0;
        
        for(int i=0; i<pos.size(); i++){
            res[p] = pos.get(i);
            res[p+1] = neg.get(i);
            p+=2;
        }
        return res;
    }
}