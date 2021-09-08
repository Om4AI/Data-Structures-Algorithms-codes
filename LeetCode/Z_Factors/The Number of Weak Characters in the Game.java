// Code by @Om
class Solution {
    public int numberOfWeakCharacters(int[][] p) {
        Arrays.sort(p, (a,b)-> a[0]==b[0]? a[1]-b[1]: b[0]-a[0]);
        int count = 0, max = 0;
        for (int i=0; i<p.length; i++){
            count+= max>p[i][1]? 1:0;
            max = Math.max(max, p[i][1]);
        }
        return count;
    }
}
