class Solution {
    public boolean canAliceWin(int[] arr) {
        int single = 0;
        int dou = 0;
        for (int i=0; i<arr.length; i++){
            if (arr[i] > 9){
                dou += arr[i];
            }else{
                single += arr[i];
            }
        }
        return !(single==dou);
    }
}
