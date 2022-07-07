class Solution {
    public static int m, n;
    public static String s, p;

    public boolean isMatch(String s1, String p1){
        s = s1;
        p = p1;
        m = s.length();
        n = p.length();
        int t[][] = new int[m+1][n+1];
        for(int i=0; i<m; i++) Arrays.fill(t[i],-1);

        return (cardMatch(0,0,t)==1)?true:false;
    }


    public static int cardMatch(int sp, int pp,int[][] t){
        // Base case
        if(sp==m && pp==n) return t[sp][pp] = 1;
        else if(sp<m && pp==n) return t[sp][pp] = 0;
        else if(sp==m && pp<n && canRemove(pp)) return t[sp][pp] = 1;
        else if(sp==m && pp<n) return t[sp][pp] = 0;

        // Memoization check 
        if(t[sp][pp]!=-1) return t[sp][pp];


        // General cases
        char scurr = s.charAt(sp), pcurr = p.charAt(pp);
        
        // Case 1: Characters equal
        if(scurr==pcurr || pcurr=='?' || pcurr=='*'){
            // Case 1: * for 0/1/multiple
            if(pcurr=='*') return t[sp][pp] = Math.max(cardMatch(sp,pp+1,t),Math.max(cardMatch(sp+1,pp+1,t),cardMatch(sp+1,pp,t)));
            // Case 2: Character or ?
            else return t[sp][pp] = cardMatch(sp+1,pp+1,t);
        }
        // Case 2: Characters not equal
        else return t[sp][pp] = 0;
    }

    public static boolean canRemove(int pp){
        for(int i=pp; i<n; i++){
            if(p.charAt(i)!='*') return false;
        }
        return true;
    }
}