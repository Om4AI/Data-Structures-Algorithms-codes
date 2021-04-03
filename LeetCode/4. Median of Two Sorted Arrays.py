class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        l1 = nums1 + nums2
        l1.sort()
        return median(l1)
