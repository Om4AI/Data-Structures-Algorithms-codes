import java.util.*;
class Solution {
    public int findJudge(int n, int[][] trust) {
        // If n==1 and he trusts noone
        if (n==1) return 1;

        int trust_others[] = new int[n+1];
        int trust_him[] = new int[n+1];

        for(int i=0; i<trust.length; i++){
            int a = trust[i][0], b = trust[i][1];
            trust_others[a]+=1;
            trust_him[b]+=1;
        }

        for (int i=0; i<n+1; i++){
            if (trust_him[i] == n-1 && trust_others[i]==0) return i;
        }
        return -1;
    }
}