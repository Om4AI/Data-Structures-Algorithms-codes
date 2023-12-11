class Solution {
    public int[] findArray(int[] pref) {
        int n = pref.length;
        int res[] = new int[n];
        res[0] = pref[0];

        for (int i=0; i<n-1; i++){
            res[i+1] = pref[i]^pref[i+1];
        }

        return res;
    }
}
