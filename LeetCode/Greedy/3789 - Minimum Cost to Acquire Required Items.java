// Learning - https://app.notion.com/p/DSA-Learnings-4158b8e2f25a8029b12efebaac4839b4?source=copy_link#4158b8e2f25a80909b92c27e91e885ef

class Solution {
    public long minimumCost(int c1, int c2, int cb, int n1, int n2) {
        // Cases
        long res = 0;
        // Case 1 - costBoth is lesser than both
        if (cb<c1 &&cb<c2) return (long)cb*Math.max(n1,n2);
        // Case 2 - costBoth is lesser than either of c1 or c2
        else if (cb<c1 || cb<c2){
            if (c1>c2){
                res += (long)cb*n1;
                if (n2>n1) res += (long)c2*(n2-n1);
            }else{ //c2>c1
                res += (long)cb*n2;
                if (n1>n2) res += (long)c1*(n1-n2);
            }
        }else{
            res = (long)c1*n1 + (long)c2*n2;
            if (n1>n2){
                long temp1 = 0, temp2 = 0;
                temp1 = (long)cb*n1;
                temp2 = (long)n2*cb + (long)(n1-n2)*c1;
                res = Math.min(res, Math.min(temp1,temp2));
            }else{ //c2>c1
                long temp1 = 0, temp2 = 0;
                temp1 = (long)cb*n2;
                temp2 = (long)n1*cb + (long)(n2-n1)*c2;
                res = Math.min(res, Math.min(temp1,temp2));
            }
        }
        return res;
    }
}