class Solution {
    public double average(int[] salary) {
        List<Integer> l = new ArrayList<>();
        int sum = 0;
        for(int i: salary){
            sum+=i;
            l.add(i);
        }
        sum-=Collections.min(l);
        sum-=Collections.max(l);
        return (double)sum/(l.size()-2);
    }
}
