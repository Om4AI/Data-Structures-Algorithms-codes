import java.util.*;
class Solution {
    public int integerReplacement(int n) {
//         Base Case
        if(n==1) return 0;
        int c = 0;
//         Actual loop
        while(n!=1){
//             Condition for odd
            if(n%2!=0){
                int sub = n-1;
                if((sub/2)%2==0 || (sub/2)==1) n-=1;
                else n+=1;
                c++;
            }
            else if(n%2==0){
                // Check the highest power of 2 to divide n
                for(int i=31; i>=1; i--){
                    if(n%(1<<i)==0){
                        n = n/(1<<i);
                        c+=i;
                        break;
                    }
                }
            }
        }
        return c;
    }
}