class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        s1 = set(nums)
        max = -111111
        for i in s1:
            if (nums.count(i)>max):
                max = nums.count(i)
                el = i
        return el
