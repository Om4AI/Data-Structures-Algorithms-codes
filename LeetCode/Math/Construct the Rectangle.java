class Solution {
    public int[] constructRectangle(int area) {
        int res[] = new int[2];
        int diff = Integer.MAX_VALUE;
        
        for(int i=1; i<=area; i++){
            if(area%i==0){
                int L = i, W = area/i;
                if(L>=W && (L-W)<diff){
                    res[0] = L;
                    res[1] = W;
                    diff = (L-W);
                }
            }
        }
        return res;
    }
}
