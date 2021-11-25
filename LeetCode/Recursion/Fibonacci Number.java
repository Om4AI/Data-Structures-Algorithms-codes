// Recursive Code
class Solution {
    public int fib(int n) {
        // Recursive code
        if (n<=1) return n;  //Base condition

        return fib(n-1)+fib(n-2);
    }
}

// DP Code
class Solution {
    public int fib(int n) {
        // DP Solution - 0ms
        int fibs[] = new int[n+1];
        fibs[0] = 0;
        if (n>0) fibs[1] = 1;

        // Store values
        for (int i=2; i<n+1; i++){
            fibs[i] = fibs[i-1]+fibs[i-2];
        }
        return fibs[n];
    }
}
