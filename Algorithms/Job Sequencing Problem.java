// Code by @Om
import java.util.*;
class Solution{

    int[] JobScheduling(Job arr[], int n){
        
        int jobs[] = new int[n];
        int dl[] = new int[n];
        int profit[] = new int[n];
        // Assign values
        for (int i=0; i<n; i++){
            jobs[i] = arr[i].id;
            dl[i] = arr[i].deadline;
            profit[i] = arr[i].profit;
        }
        // Sort jobs according to profit
        for (int i=0; i<n-1; i++){
            for (int j=i+1; j<n; j++){
                if (profit[i]<profit[j]){
                    int t = profit[i];
                    profit[i] = profit[j];
                    profit[j] = t;
                    t = jobs[i];
                    jobs[i] = jobs[j];
                    jobs[j] = t;
                    t = dl[i];
                    dl[i] = dl[j];
                    dl[j] = t;
                }
            }
        }
        int tm = 0;
        for (int i=0; i<n; i++){
            if (dl[i]>tm){
                tm = dl[i];
            }
        }
        int res[] = new int[tm];
        // Allocate jobs to intervals
        int max_prof = 0, jd = 0;
        // Iterate over all jobs
        for (int i=0; i<n; i++){
            int d = dl[i];
            for (int j=d-1; j>-1; j--){
                if (res[j]==0){
                    res[j] = jobs[i];
                    max_prof+=profit[i];
                    jd+=1;
                    break;
                }
            }
        }
        int r[] = new int[2];
        r[0] = jd;
        r[1] = max_prof;
        return r;
    }
}
