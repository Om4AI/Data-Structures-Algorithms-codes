class Solution {
    public boolean isPowerOfFour(int n) {
        int i=0;
        List<Integer> list = new ArrayList<Integer>();
        while ((int)Math.pow(4,i) <= (int)Math.pow(2,31)-1){
            list.add((int)Math.pow(4,i));
            i+=1;
        }
        return (n>0 && list.contains(n));
    }
}
