class Solution {
    public int addRungs(int[] rungs, int dist) {
        int val = 0, add_count=0;
        for (int i=0; i<rungs.length; i++){
            if (rungs[i]-val<=dist){
                val = rungs[i];
            }
            else{
                if ((rungs[i]-val)%dist==0){
                    add_count += (((rungs[i]-val)/dist)-1);
                }
                else{add_count += ((rungs[i]-val)/dist);}
                val = rungs[i];
            }
        }
        return add_count;
    }
}
