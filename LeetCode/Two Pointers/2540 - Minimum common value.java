// Two pointers approach
//     1. For every pair of elements, check which is greater and accordingly increment the other
//     2. This approach is O(n) which is better than the brute force O(n^2) solution
class Solution {
    public int getCommon(int[] arr1, int[] arr2) {
        int i=0, j=0;
        while (i<arr1.length && j<arr2.length){
            if (arr1[i] == arr2[j]) return arr1[i];
            if (arr1[i] < arr2[j]) i++;
            else if (arr2[j] < arr1[i]) j++;
        }
        return -1;
    }
}
