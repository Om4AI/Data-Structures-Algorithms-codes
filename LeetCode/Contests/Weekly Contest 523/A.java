import java.util.*;

class Solution {
    public boolean threeFibonacciSum(int n) {
        if (n%2!=0) return false;
        int c = n/2;

        int a = 0, b=1;
        while (a+b < c){
            int temp = a+b;
            a = b;
            b = temp;
        }
        return (a+b==c);
    }
}©leetcode