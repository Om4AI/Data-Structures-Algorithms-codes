class Solution {
    public int palindromicPartition(String s){
        int n = s.length(), i=0, j = s.length()-1;

        // Matrix to store calculated answers
        int t[][] = new int[n+1][n+1];
        for(int i1=0; i1<n+1; i1++){
            Arrays.fill(t[i1], -1);
        }
        return min_palin_partition(s, n, t, i, j);
    }

    public static int min_palin_partition(String s, int n, int[][] t, int i, int j) {

        // Base condition
        if(i>=j) return 0;
        if(isPalindrome(s,i,j)) return 0;

        // Memoization check
        if(t[i][j]!=-1) return t[i][j];

        // K scheme loop
        int res = Integer.MAX_VALUE;
        for(int k=i; k<=j-1; k++){
            int tempans = min_palin_partition(s,n,t,i,k) + 1 + min_palin_partition(s,n,t,k+1,j);

            // Operation on tempans
            res = Math.min(res, tempans);
        }
        return t[i][j] = res;
    }

    public static boolean isPalindrome(String s, int i, int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}