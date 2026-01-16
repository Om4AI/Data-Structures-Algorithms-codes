class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int res = 0;
        int gp = 0, sp = 0;
        while (gp<g.length && sp<s.length){
            if (s[sp]>=g[gp]){
                res++;
                sp++;
                gp++;
            }else if(g[gp]>s[sp]){
                sp++;
            }
        }
        return res;
    }
}
