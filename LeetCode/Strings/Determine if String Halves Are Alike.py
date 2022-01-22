class Solution:
    def halvesAreAlike(self, s: str) -> bool:
        n = len(s)
        n1 = int(n/2)
        s1 = s[:n1].lower()
        s2 = s[n1:].lower()
        l1 = ['a','e','i','o','u']
        c1 = 0
        c2 = 0
        for i in l1:
            c1 += s1.count(i)
        for j in l1:
            c2 += s2.count(j)
        if (c1 == c2): return True
        else:return False
