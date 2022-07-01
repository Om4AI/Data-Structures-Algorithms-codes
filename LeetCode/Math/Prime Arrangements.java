class Solution {
    public int numPrimeArrangements(int n){
        int prime = 0, comp = 0;

        for(int i=2; i<=n; i++) prime = (isPrime(i))? prime+1:prime+0;
        comp = n-prime;
        
        return (int)(fact(prime)%1000000007*fact(comp)%1000000007)%1000000007;
    }


    public static boolean isPrime(int n){
        // Case 1: 0 & 1
        if(n<=1) return false;

        // Case 2: 2 & 3
        if(n==2 || n==3) return true;

        // Case 3: Multiples of 2 & 3
        if(n%2==0 || n%3==0) return false;

        // Loop over from 5 to sqrt(n)
        for(int i=5; i<=Math.sqrt(n); i+=6){
            // 5 & 7 (Rest all numbers are multiples of 2 & 3)
            if(n%i==0 || n%(i+2)==0) return false;
        }
        return true;
    }


    public static long fact(int n){
        if(n==0 || n==1) return 1%1000000007;

        long fact = 1;
        for(int i=2; i<=n; i++){
            fact *= i;
            fact%=1000000007;
        }
        return fact%1000000007;
    }
}