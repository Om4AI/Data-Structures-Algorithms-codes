# Candies

n = int(input())
ratings = []
candy = []
for i in range(n):
    el = int(input())
    ratings.append(el)
    candy.append(1)
for i in range(n-1):
    if (ratings[i+1]>ratings[i]):
        candy[i+1] = candy[i] + 1
for i in range(n-1,0,-1):
    if (ratings[i-1]>ratings[i] and candy[i-1]<= candy[i]):
        candy[i-1] = candy[i] + 1
print(sum(candy))
