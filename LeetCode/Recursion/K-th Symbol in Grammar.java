class Solution {
    public int kthGrammar(int n, int k){
        return Character.getNumericValue(findChar(n,k-1));
    }
    
    public static char findChar(int n, int k){
        // Base case
        if(n==1) return '0';
        
        // Main Logic - 2 cases based on K value
        // Even - (k/2)th character of (n-1)th term
        // Odd -  Opposite of ((k-1)/2th character of (n-1)th term)
        if(k%2==0){
            return findChar(n-1,k/2);
        }else{
            return (findChar(n-1,(k-1)/2)=='1')?'0':'1';
        }
    }
}