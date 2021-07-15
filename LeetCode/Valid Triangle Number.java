// Code by @Om

class Solution {
    public int triangleNumber(int[] nums) {
        int triangles = 0;
        Arrays.sort(nums); // Sort the possible sides for later logic

        for (int i=nums.length-1; i>=2; i--){
            int l = 0, r = i-1;
            while (l < r){
                if (nums[l]+nums[r] > nums[i]){
                    triangles += r-l;    // As (l+r)>i then all the sides after l (greater than l(As array is sorted) will satisfy the condition)
                    r--; //keep longest side fix and reduce r till condition satifies
                }
                else{l++;} //l is not enough for the condition perhaps
            }
        }
        return triangles;
    }
}
