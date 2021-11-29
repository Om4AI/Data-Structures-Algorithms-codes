import math 
t = int(input())
for i in range(t):
    n, k = map(int, input().split())
    print(int((n/math.gcd(n,k))))
