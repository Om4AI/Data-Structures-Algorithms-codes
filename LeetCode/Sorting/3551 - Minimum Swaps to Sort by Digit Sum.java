import java.util.*;

// Logic -
// 1. Define a custom class with every object having 2 values - sum of digits & value
// 2. Calculate the sum of digits of every number & at the same time store the indices of each number (Hashmap) & populate the array of Num objects
// 3. Sort the array of objects using Custom comparator in Java with 2 conditions of sum of digits & value one after other
// 4. Count the number of swaps by going through the original array & sorted array & whenever there is a mismatch, swap & update the Hashmap to maintain the latest indices
// 5. Return the number of swaps

class Num{
    int sumOD;
    int value;
    Num(int sod, int val){
        this.sumOD = sod;
        this.value = val;
    }
}

class Solution {
    public int minSwaps(int[] arr){
        // Calculate the sum of digits
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        Num[] nums = new Num[n];
        for (int i=0; i<n; i++) {
            int temp = arr[i], tempSum = 0;
            map.put(temp, i);
            while(temp>0){
                tempSum += temp%10;
                temp /= 10;
            }
            nums[i] = new Num(tempSum, arr[i]);
        }

        // Sort the nums array
        Arrays.sort(nums, Comparator.comparingInt((Num m)-> m.sumOD).thenComparingInt(m -> m.value));


// TODO: Maintain the current latest position of each element (Use a hashmap)

        int swps = 0, p = 0;
        while (p<n){
            if (arr[p] != nums[p].value){
                // Current position of character
                int pos = map.get(nums[p].value);
                // Perform the swap
                map.put(arr[p], pos);
                arr[pos] = arr[p];
                arr[p] = nums[p].value;
                swps++;
            }
            p++;
        }
        return swps;
    }
}