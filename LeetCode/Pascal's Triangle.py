class Solution:
    def generate(self, n: int) -> List[List[int]]:
        if (n ==1): res = [[1]]
        elif (n==2): res= [[1],[1,1]]
        else:
            res = [[1],[1,1]]
            for i in range(3, n+1):
                t = [1]
                for j in range(0,len(res[i-2])-1):
                    t.append(int(res[i-2][j] + res[i-2][j+1]))
                t.append(1)
                res.append(t)
        return res
