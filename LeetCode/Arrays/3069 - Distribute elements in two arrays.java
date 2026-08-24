class Solution {
    public int[] resultArray(int[] arr){
        int n = arr.length, p = 1;
        int res[] = new int[n];
        int arr2[] = new int[n+1];
        res[0] = arr[0];
        arr2[0] = arr[1];
        int cp1 = 0, cp2 = 0;
        for (int i=2; i<n; i++){
            if (res[cp1] > arr2[cp2]){
                cp1++;
                res[cp1] = arr[i];
            }else{
                cp2++;
                arr2[cp2] = arr[i];
            }
        }

        cp1++;
        for (int i=0; i<n+1; i++){
            if (arr2[i]==0) return res;
            else{
                res[cp1] = arr2[i];
                cp1++;
            }
        }
        return res;
    }
}
