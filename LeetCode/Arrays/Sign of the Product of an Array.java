class Solution {
    public int arraySign(int[] nums) {
        int prod = 1;
        for (int i: nums){
            if(i==0) return 0;
            int t = (i>0)?1:-1;
            prod*=t;
        }
        
        if(prod==0) return 0;
        return (prod>0)? 1:-1;
    }
}
