import java.util.*;

class Solution {
    public List<Integer> maxPrimes(int n, int s) {
        // Find all primes till n
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int p=2; p*p<=n; p++){
            if (isPrime[p]==true){
                for (int i=p*p; i<=n; i+=p){
                    isPrime[i] = false;
                }
            }
        }

        // List of all primes
        List<Integer> primes = new ArrayList<>();
        for (int i=0; i<n+1; i++){
            if (isPrime[i]==true) primes.add(i);
        }

        long sum = 0;
        List<Integer> res = new ArrayList<>();
        for (int i=0; i<primes.size(); i++){
            if ((sum + primes.get(i))<=s){
                res.add(primes.get(i));
                sum += primes.get(i);
            }else break;
        }
        return res;
    }
}