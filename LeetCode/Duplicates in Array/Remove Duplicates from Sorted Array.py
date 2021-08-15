class Solution:
    def removeDuplicates(self, l1: List[int]) -> int:
        l2 = set(l1)
        l1.clear()
        for i in l2:l1.append(i)
        l1.sort()
        return len(l1)
