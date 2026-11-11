import java.util.*;

class Solution {
    static int n;
    static int[] costs;

    public int climbStairs(int target, int[] arr) {
        n = target;
        costs = new int[n + 1];

        for (int i = 0; i < arr.length; i++) {
            costs[i + 1] = arr[i];
        }

        List<Integer> dp = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            dp.add(-1);
        }

        return getMinCost(0, 0, dp);
    }

    int getMinCost(int start, int curr, List<Integer> dp) {
        if (dp.get(start) != -1) {
            return curr + dp.get(start);
        }

        if (start == n) {
            dp.set(start, 0);
        } else if (start == n - 1) {
            dp.set(start, costs[n] + 1);
        } else if (start == n - 2) {
            int one = getMinCost(start + 1, curr + (costs[start + 1] + 1), dp);
            int two = getMinCost(start + 2, curr + (costs[start + 2] + 4), dp);

            dp.set(start, Math.min(one, two) - curr);
        } else if (start < n - 2) {
            int one = getMinCost(start + 1, curr + (costs[start + 1] + 1), dp);
            int two = getMinCost(start + 2, curr + (costs[start + 2] + 4), dp);
            int three = getMinCost(start + 3, curr + (costs[start + 3] + 9), dp);

            dp.set(start, Math.min(one, Math.min(two, three)) - curr);
        } else {
            return curr;
        }

        return curr + dp.get(start);
    }
}