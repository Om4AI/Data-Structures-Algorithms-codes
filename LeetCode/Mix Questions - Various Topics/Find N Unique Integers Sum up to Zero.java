class Solution {
    public int[] sumZero(int n) {
        int t = 1;
        int arr[] = new int[n];
        if (n % 2==0){
            int i =0;
            while (i<n){
                arr[i]= t;
                arr[i+1] = -t;
                i+=2;
                t+=1;
            }
        }
        else if (n % 2==1){
            arr[0] = 0;
            int i =1;
            while (i<n){
                arr[i]= t;
                arr[i+1] = -t;
                i+=2;
                t+=1;
            }
        }
        return arr;
    }
}
