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

3. Whenever we have something like appending numbers one after the other like (1..2..3..4)
   Always use the approach of -
   ```
   res = res * 10 + number

   This helps to save conversion from strings to numbers and vice versa
   ```

4. `BigInteger` is one of the most important classes in Java. It is used to perform arithmetic operations when the data is not in the
   range of any of the other datatypes.
   ```
   Some of the methods of BigInteger -
   1. add()
   2. multiply()
   3. pow()
   4. abs()
   5. intValue()
   6. longValue()

   Check the question - Large factorial (Interviewbit)
   ```

5. `Time Complexity lesson`: Sometimes we shouldn't directly think in terms of the most optimized solution. We must see what the input is and accordingly think about what could be the acceptable time complexity.
   Sometimes a $$O(n^3)$$ solution can also work.
   ```
   Example: In the question:
            Valid IP Addresses (Interviewbit):  The maximum input cannot be that huge because it is an IP address.
                                                So, in this case, an O(n^3) solution will also work
                                                according to the input.
   ```
