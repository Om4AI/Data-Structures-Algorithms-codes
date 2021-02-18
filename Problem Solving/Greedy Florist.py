n,k=list(map(int,input().split(" ")))
l1=list(map(int,input().split(" ")))
l1.sort()
cost=0
d=1
m=1
while (n>0):
    if (d>k):
        d=1
        m+=1
    else:
        n1=len(l1)-1
        el=l1[n1]
        cost+=(m*el)
        l1.pop(n1)
        d+=1
        n-=1
print(cost)
