class Solution {
    public int mostWordsFound(String[] sen) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<sen.length; i++){
            String[] arr = sen[i].split(" ");
            max = Math.max(max, arr.length);
        }
        return max;
    }
}
