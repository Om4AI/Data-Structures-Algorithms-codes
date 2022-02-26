class Solution {
    public int subtractProductAndSum(int n) {
        String s = Integer.toString(n);
        int prod = 1, sum = 0;
        for(int i=0; i<s.length(); i++){
            int c = Character.getNumericValue(s.charAt(i));
            prod*=c;
            sum+=c;
        }
        return prod-sum;
    }
}
