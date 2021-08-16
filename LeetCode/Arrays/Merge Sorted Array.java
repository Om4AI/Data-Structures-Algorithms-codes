// Merge Sorted Array: Java Code (0ms)

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> l = new ArrayList<>();
        int i=0, j=0;
        while (i<m && j<n){
            if (nums1[i] < nums2[j]){
                l.add(nums1[i]);
                i++;
            }
            else if (nums2[j] < nums1[i]){
                l.add(nums2[j]);
                j++;
            }
            else {
                l.add(nums1[i]);
                l.add(nums2[j]);
                i++;
                j++;
            }
        }
        while (i<m){
            l.add(nums1[i]);
            i++;
        }
        while (j<n){
            l.add(nums2[j]);
            j++;
        }
        for (i=0; i<l.size(); i++){nums1[i] = l.get(i);}
    }
}
