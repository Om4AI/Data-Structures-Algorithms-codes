# Simple Python Code

import itertools
from itertools import combinations

class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        l1 = [[]]
        for c in range(1, len(nums)+1):
            combs = set(combinations(nums, c))
            for el in combs: l1.append(el)
        return l1
