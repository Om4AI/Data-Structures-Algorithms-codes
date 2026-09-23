import java.util.*;

class Solution {
    static class timeAction{
        int time;
        char action;
    }

    public int minPlatform(int arr[], int dep[]) {
        int n = arr.length;
        // Create a list of timeAction objects
        List<timeAction> l = new ArrayList<>();
        for (int i=0; i<n; i++){
            timeAction atemp = new timeAction();
            atemp.time = arr[i];
            atemp.action = 'a';

            timeAction dtemp = new timeAction();
            dtemp.time = dep[i];
            dtemp.action = 'd';
            l.add(atemp);
            l.add(dtemp);
        }

        // Sort the timeActions based on time & if same sort the arrival first before departure
        // The second comparison happens based on ASCII values hence ints are compared
        Collections.sort(l, Comparator.comparingInt((timeAction ta) -> ta.time).thenComparingInt(ta -> ta.action));

        // Iterate the list to find the maximum number of platforms required
        int maxPlatforms = 1, currentFree = 1;
        for (int i=0; i<2*n; i++){
            timeAction temp = l.get(i);
            if (temp.action == 'a'){
                // No platform is free so we need a new one
                if (currentFree == 0) maxPlatforms++;
                else if (currentFree > 0) currentFree--;
            }else if (temp.action == 'd'){
                // Free up one of the platforms
                currentFree++;
            }
        }
        return maxPlatforms;
    }
}