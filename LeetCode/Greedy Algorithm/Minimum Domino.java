class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        // Find the common element
        int a = tops[0], b = bottoms[0], af = 1, bf = 1, n = tops.length;

        // Check a
        for(int i=1; i<n; i++){
            if(a!=tops[i] && a!=bottoms[i]){
                af = 0;
                break;
            }
        }

        // Check b
        for(int i=1; i<n; i++){
            if(b!=tops[i] && b!=bottoms[i]){
                bf = 0;
                break;
            }
        }

        if(af==0 && bf==0) return -1;
        int el = (af==1)?a:b;

        // Check occureneces
        int tocc = 0, bocc =0;
        for(int i=0; i<n; i++){
            if(tops[i]==el) tocc++;
            if(bottoms[i]==el) bocc++;
        }
        return Math.min(n-tocc, n-bocc);
    }
}