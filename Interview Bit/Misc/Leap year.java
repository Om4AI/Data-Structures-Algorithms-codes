public class Solution {
    public int solve(int A){
        // Condition 1
        if(A%100==0 && A%400==0) return 1;
        else if(A%100==0 && A%400!=0) return 0;

        // Condition 2
        else if(A%4==0) return 1;
        else return 0;
    }
}
