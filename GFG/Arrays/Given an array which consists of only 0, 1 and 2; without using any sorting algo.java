class Solution
{
    public static void sort012(int arr[], int n)
    {
        int p = 0;
        for(int i=0; i<n; i++){
            if(arr[i]==0){
                int t = arr[p];
                arr[p] = 0;
                arr[i] = t;
                p++;
            }
        }
        for(int i=p; i<n; i++){
            if(arr[i]==1){
                int t = arr[p];
                arr[p] = 1;
                arr[i] = t;
                p++;
            }
        }
    }
}
