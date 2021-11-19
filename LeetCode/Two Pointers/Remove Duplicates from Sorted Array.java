class Solution {
    public int removeDuplicates(int[] arr){
        int i=0;
        for (int j=1; j<arr.length; j++){
//             Just find a new number and put it to next of current i
            if(arr[i]!=arr[j]){
                i++;
                arr[i] = arr[j];
            }
        }
        return i+1;
        
    }
}
