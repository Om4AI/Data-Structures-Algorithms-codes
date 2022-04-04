class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        List<Integer> l = new ArrayList<>();
        for (int i: nums) l.add(i);

        while(n!=1){
            l = get_updated(l);
            n--;
        }
        return l.get(0);
    }

    public static List<Integer> get_updated(List<Integer> l){
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<l.size()-1; i++){
            res.add((l.get(i)+l.get(i+1))%10);
        }
        return res;
    }
}