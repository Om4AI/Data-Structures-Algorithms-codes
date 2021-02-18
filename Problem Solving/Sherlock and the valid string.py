s=input("")
l1=[]
for el in s:
    l1.append(el)
l2=set(l1)
l1=list(l2)
l3=[]
counts=[]
for el in l1:
    n=s.count(el)
    l3.append(n)
# print(l3)
l4=set(l3)
# print(l4)
l1={}
for el in l4:
    n1=l3.count(el)
    l1[n1]=el

ace=l1[max(l1.keys())]
c=0
f=0
for i in l3:
    if (i!=ace):
        c+=1
        if (c==1):
            com=i
    else:
        continue

if (c==1):
    if (com>ace and (com-ace)>1):
        f=1
    elif (com<ace and (com!=1)):
        f=1


if (len(l4)>2 or (c>1) or (f==1)):
    print("NO")
else:
    print("YES")
