class Solution {
    public String largestOddNumber(String num){
        int end = 0;
        for (int i=num.length()-1; i>=0; i--){
            int temp = Character.getNumericValue(num.charAt(i));
            if (temp%2==1) break;
        }

        return num.substring(0, end);
    }
}