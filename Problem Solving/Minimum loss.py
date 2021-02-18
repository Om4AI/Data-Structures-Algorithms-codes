n =  int(input().strip())
numbers = list(map(int,input().strip().split()))

nums = list(numbers)
nums.sort()
minCost = 10**10
for i in range(1,n):
    if (nums[i]-nums[i-1] < minCost)  and (numbers.index(nums[i]) < numbers.index(nums[i-1])):
        minCost = nums[i]-nums[i-1]
print(minCost)
