class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n==0) return 1;
        
        int[] arr = {9,9,8,7,6,5,4,3,2,1};
        int count = 10;
        for(int i=1; i<n; i++){
            int pos_nums = 1;
            for (int j=0; j<=i; j++){
                pos_nums*=arr[j];
            }
            count+=pos_nums;
        }
        return count;
    }
}
