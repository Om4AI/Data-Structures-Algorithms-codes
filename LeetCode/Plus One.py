class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        s=""
        for i in range(len(digits)):s+=str(digits[i])
        n = int(s)
        s = str(n+1)
        l2 = list(s)
        return l2
