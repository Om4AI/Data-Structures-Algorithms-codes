class Solution {
    public int largestPerimeter(int[] arr){
        List<Integer> l = new ArrayList<>();
        for (int i: arr)l.add(i);
        Collections.sort(l, Collections.reverseOrder());
        
        int p = 0, n = l.size(), max = 0;
        while(p<=n-3){
            if((l.get(p+2)+l.get(p+1))>l.get(p)){
                max = Math.max(max, l.get(p)+l.get(p+1)+l.get(p+2));
            }
            p++;
        }
        return max;
    }
}