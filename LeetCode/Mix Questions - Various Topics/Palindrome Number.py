class Solution:
    def isPalindrome(self, x: int) -> bool:
        s = str(x)
        s1 = s[::-1]
        return (s==s1)
        
