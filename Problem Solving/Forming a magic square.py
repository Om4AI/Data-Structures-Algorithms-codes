def calculate(l,t):
    count=0
    for i in range(3):
        for j in range(3):
            if (l[i][j]==t[i][j]):
                continue
            else:
                count+=abs(l[i][j]-t[i][j])
    return count



l=[]
for i in range(3):
    temp=list(map(int,input().split(" ")))
    l.append(temp)
l1=[[[8,1,6],[3,5,7],[4,9,2]],[[6,1,8],[7,5,3],[2,9,4]],[[4,9,2],[3,5,7],[8,1,6]],[[2,9,4],[7,5,3],[6,1,8]],[[8,3,4],[1,5,9],[6,7,2]],[[4,3,8],[9,5,1],[2,7,6]],[[6,7,2],[1,5,9],[8,3,4]],[[2,7,6],[9,5,1],[4,3,8]]]
total=[]
for i in range(8):
    total.append(calculate(l,l1[i]))
print(min(total))
