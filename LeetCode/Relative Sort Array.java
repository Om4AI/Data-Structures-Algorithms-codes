class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int c = 0;
        for (int i=0; i<arr2.length; i++){
            int el = arr2[i];
            for (int j=0; j<arr1.length; j++){
                if (arr1[j] == el){
                    int t = arr1[c];
                    arr1[c] = el;
                    arr1[j] = t;
                    c += 1;
                }
            }
        }
        for (int i=c; i<arr1.length-1; i++){
            for (int k=i+1; k<arr1.length; k++){
                if (arr1[i]>arr1[k]){
                    int t1 = arr1[i];
                    arr1[i] = arr1[k];
                    arr1[k] = t1;
                }
            }
        }
        return arr1;
    }
}
