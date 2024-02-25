### Dynamic Programming (DP)

This README file is specially for focusing on Dynamic Programming, as I am fascinated by this topic

<p align="center">Coding Websites</p>
<p align="center">
<img src="/Readme Resources/leetcode_icon.png" height="50px" width="50px" alt="">
<img src="/Readme Resources/interview_bit_2.png" height="70px" width="70px" alt="">
</p>

<p align="center">DSA Tech Stack</p>
<p align="center">
<img src="/Readme Resources/java_icon.png" height="60px" width="60px" alt="">
</p>

#### Some of my important DP learnings - 

1. In Bottom Up approach (Tabulation), dp[ind] is actually the recursive function in Memoization (Top down) <br> so replace every function call with dp[ind...] when we write bottom up's loop
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

2. The Bottom Up approach code can be easily written, just perform the Memoization function logic inside an outer loop.
   Mostly there is no need to change the Memoization function logic
   ```
   Refer:  132 - Palindrome Partitioning II - Top Down
           132 - Palindrome Partitioning II - Bottom Up
   ```

3. The constraints in a DP question can sometimes reduce the runtime drastically. In the question `Word Break`, on InterviewBit the solution failed because the constraint said that the `WordDict` list can have a word with a maximum length of 20.
   Just enforcing this constraint led to acceptance of the solution reducing the runtime by a significant amount.
   ```
   for (int i=ind; i<Math.min(n, ind+21); i++){
      String curr_substring = s.substring(ind, i+1);

      // Check if current substring is present in word dictionary
      if (dict.contains(curr_substring)){
          // Break here and call recursive on rest OR continue
          res = res || can_wordbreak(i+1);
      }
   }

   The i's range goes from ind to min(n, ind+21), thus we check words with the maximum length of 20.
   ```
