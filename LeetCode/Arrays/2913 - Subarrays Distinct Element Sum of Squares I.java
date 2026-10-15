// Logic -
// For every number, keep looping through the complete array after it by moving the endpoint (j)
// For every new number traversed check if its unique and if so, add the sum of square of uniques till that point

class Solution {
    public int sumCounts(List<Integer> list) {
        int n  = list.size();
        int res = 0;
        for (int i=0; i<n; i++){
            int[] count = new int[102];
            int unique = 0;
            for (int j=i; j<n; j++){
                int num = list.get(j);
                if (count[num+1]==0){
                    unique++;
                    count[num+1] = count[num+1]+1;
                }
                res+=(unique*unique);
            }
        }
        return res;
    }
}