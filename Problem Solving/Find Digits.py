t=int(input(""))
l1=[]
l2=[]
c=0
for i in range(0,t):
    n=input("")
    l1.append(n)
for item in l1:
    for j in range(0,len(item)):
        if int(item[j])==0:
            continue
        elif (int(item))%(int(item[j]))==0:
            c+=1
        else:
            continue
    l2.append(c)
    c=0
for t in l2:
    print(t)
