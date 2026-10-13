import java.util.*;

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length, k = k1+k2;
        int[] diffs = new int[n];
        for (int i=0; i<n; i++){
            diffs[i] = Math.abs(nums1[i] - nums2[i]);
        }
        if (k==0) return getSquaredSum(diffs);

        Arrays.sort(diffs);
        int[] toMinus = new int[n];
        int q = k/n, r = k%n;
        Arrays.fill(toMinus, 0, r, q+1);
        Arrays.fill(toMinus, r, n, q);

        for (int i=0; i<n; i++){
            System.out.print(toMinus[i]+" ");
        }
        return 1;
    }

    long getSquaredSum(int[] arr){
        long res = 0;
        for (int i=0; i<arr.length; i++){
            res+= arr[i] * arr[i];
        }
        return res;
    }
}