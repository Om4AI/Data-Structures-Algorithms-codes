def think_split(i1,fi,lin,lfi):
    if (lin<lfi or (lin==lfi)):
        count=0
        for i in range(lin):
            if (i1[i]!=fi[i]):
                count+=lin-i
                i1=i1[:i]
                break
            else:continue
        count+=(lfi-(len(i1)))
    elif (lfi<lin):
        count=0
        for i in range(lfi):
            if (fi[i]!=i1[i]):
                count+=(lin-i)
                count+=(lfi-i)
                i1=i1[:i]
                break
            else:continue
        if (count==0):
            count+=lin-lfi
        else:count+=0
    # print(count)
    return count


i1=input()
fi=input()
n=int(input())
lin,lfi=len(i1),len(fi)
c=think_split(i1,fi,lin,lfi)
if (n==c):
    print('Yes')
elif (lin==lfi and n>2*(lin)):
    print('Yes')
elif (n>c and ((n-c)%2==0 or lfi==1)):
    print('Yes')
else:print('No')
