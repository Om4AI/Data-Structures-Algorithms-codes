import java.util.*;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost){

        // Base Case
        if(cost.length==1 && gas[0]>=cost[0]) return 0;

        // Find stations where gas is lesser than required
        // These stations require to get extra gas from other stations, so if journey begins to their right then this may work
        int min_index = -1, n = cost.length;
        for(int i=0; i<n; i++){
            if(gas[i]-cost[i]<0){
                min_index = i;
                min_index = (min_index+1)%n;
                if(canTravelCircuit(min_index,gas,cost)) return min_index;
            }
            // Repeating case with smallest index expected.
            else{
                min_index = i;
                if(canTravelCircuit(min_index,gas,cost)) return min_index;
            }
        }
        return -1;
    }


    public static boolean canTravelCircuit(int index, int[] gas, int[] cost){
        if(gas[index]<cost[index]) return false;
        int n = cost.length, tank= gas[index]-cost[index], p=(index+1)%cost.length;
        
        while(p!=index){
            tank+=gas[p];
            if(tank<cost[p])return false;
            else{
                tank-=cost[p];
                p = (p+1)%n;
            }
        }
        return true;
    }
}