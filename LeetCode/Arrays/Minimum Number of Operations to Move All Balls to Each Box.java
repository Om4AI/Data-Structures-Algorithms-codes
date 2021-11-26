// Brute Force
class Solution {
    public int[] minOperations(String boxes) {
        int[] res = new int[boxes.length()];
        
        for(int i=0; i<res.length; i++){
            int sum = 0;
            for (int j=0; j<res.length; j++){
                sum+= (Math.abs(j-i) * Character.getNumericValue(boxes.charAt(j)));
            }
            res[i] = sum;
        }
        return res;
    }
}
