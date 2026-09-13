import java.util.*;

class Job{
    int profit, diff;
    Job(int p, int d){
        profit = p;
        diff = d;
    }
}

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker){
        
        // Create an array of Job objects
        int n = profit.length;
        Job[] arr = new Job[n];
        for(int i=0; i<n; i++){
            Job j = new Job(profit[i], difficulty[i]);
            arr[i] = j;
        }
        
        // Sort in descending order
        Arrays.sort(arr, (a,b)->b.profit-a.profit);

        // Traverse for every worker to find maximum profit
        int res = 0;
        for(int w: worker){
            // Traverse through Jobs 
            for(int i=0; i<n; i++){
                Job j = arr[i];
                if(w>=j.diff){
                    res+=j.profit;
                    break;
                }
            }
        }
        return res;
    }
}