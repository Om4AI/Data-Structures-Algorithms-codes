class Solution {
    public int minOperations(int n) {
//         Array made
        int arr[] = new int[n];
        int c = 1, sum=0,res = 0;
        for (int i=0; i<n; i++){
            arr[i] = c;
            sum+=arr[i];
            c+=2;
        }
        
//      Average
        int avg = sum / n;
        for (int i=0;i<n;i++){
            if (arr[i]< avg){res+=avg-arr[i];}
        }
        return res;
    }
}
