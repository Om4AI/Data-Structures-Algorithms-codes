## Data Structures and Algorithms


The repository contains my solutions for various data structures and algorithm problems.
DSA is very important for developing logic and improving problem-solving skills. These skills help us to think about a problem in all possible ways. 

<p align="center">Coding Websites</p>
<p align="center">
<img src="Readme Resources/leetcode_icon.png" height="50px" width="50px" alt="">
<img src="Readme Resources/interview_bit_2.png" height="70px" width="70px" alt="">
</p>

<p align="center">DSA Tech Stack</p>
<p align="center">
<img src="Readme Resources/java_icon.png" height="60px" width="60px" alt="">
<img src="Readme Resources/python_icon.png" height="60px" width="60px" alt="">
</p>

#### Some of my important learnings - 
1. Runtime of a code doesn't only depend on the time complexity of the code, it also depends on the type of Data Structures used.
   ```
    Example: HashMaps and Arrays used for the same use case could have the same TC,
             but the run time for HashMap code is longer.
    Hence, whenever possible make use of simpler data structures.
    Reference: 2482 - Leetcode
   ```

2. Custom Sorting is an important topic: Helps to simplify problems when sorting is required on a sub-value in an array's element

   ```
    Example: Arrays.sort(<Array>, <Custom Lambda Function>)
    Reference: 451 - Leetcode
   ```

3. In Bottom Up approach (Tabulation), dp[ind] is actually the recursive function in Memoization (Top down) <br> so replace every function call with dp[ind...] when we write bottom up's loop
   ```
   -------- Top Down --------
   for (int i=ind; i<Math.min(n, ind+k); i++){
            ...

            int sum = (len*max) + max_partition_sum(i+1);
            max_sum = Math.max(max_sum, sum);
        }
        return dp[ind] = max_sum;

   
   -------- Bottom Up --------
   for (int ind=n-1; ind>=0; ind--){
            ...
            for (int i=ind; i<Math.min(n, ind+k); i++){
                ...

                int sum = (len*max) + dp[i+1];
                max_sum = Math.max(max_sum, sum);
            }
            dp[ind] = max_sum;
        }


   The max_partition_sum(i+1) has been replaced by dp[i+1]
   ```
