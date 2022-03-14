public class Solution {
    public int sqrt(int n){
        // Define Range for searching the Squareroot
        int s = 0, e = n;
        while(s<=e){
            int mid = s+(e-s)/2;
            // Condition to prevent overflow
            if(mid>46340){
                e = mid-1;
                continue;
            }
            int sq = mid*mid;
            if(sq==n) return mid;
            else if(sq>n) e = mid-1;
            else s = mid+1;
        }
        
        // Proper Squareroot not found
        s = 0;
        e = n-1;
        while(s<=e){
            int mid = s+(e-s)/2;
            // Condition to prevent overflow
            if(mid>46339){
                e = mid-1;
                continue;
            }
            int sq = mid*mid, sqnext = (mid+1)*(mid+1);
            if(sq<n && sqnext>n) return mid;
            else if(sq>n) e = mid-1;
            else s = mid+1;
        }
        return s;
    }
}