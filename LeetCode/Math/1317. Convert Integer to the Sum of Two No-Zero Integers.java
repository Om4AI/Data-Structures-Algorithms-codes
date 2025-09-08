// Just some Brute force logic - But there is no other way
class Solution {
    public int[] getNoZeroIntegers(int n) {
        for (int a=1; a<n; a++){
            int b = n-a;
            if (!String.valueOf(b).contains("0") && !String.valueOf(a).contains("0")){
                return new int[] {a,b};
            }
        }
        return new int[0];
    }
}
