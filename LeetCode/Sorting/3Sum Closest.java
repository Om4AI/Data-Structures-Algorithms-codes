// Code by @Om 
// Sorting & 2 pointers: Java Code

class Solution {
    public int threeSumClosest(int[] arr, int target) {
        Arrays.sort(arr);
        HashSet<Integer> set = new HashSet();
        int n = arr.length;
//         First element
        for (int i=0; i<=n-3; i++){
            int el = arr[i];
            int diff = Integer.MAX_VALUE, sum = 0;
            int j = i+1, k= n-1;  // Two pointers
            
            
//             Find the sum closest to the target (Actual Logic)
            while (j<k){
                int inner_sum = el + arr[j]+arr[k];
//                 Condition 1
                if (inner_sum == target){
                    diff = 0;
                    sum = target;
                    break;
                }else if (inner_sum < target){
//                     Check current diff with target
                    if (Math.abs(target - inner_sum) < diff){
                        diff = Math.abs(target - inner_sum);
                        sum = inner_sum;
                        j++;
                    }else{j++;}
                }else if (inner_sum > target){
//                     Check current diff with target
                    if (Math.abs(inner_sum - target) < diff){
                        diff = Math.abs(inner_sum - target);
                        sum = inner_sum;
                        k--;
                    }else{k--;}
                }
            }
            
            set.add(sum);   // Add the closest sum to the HashSet
        }
//       Get the sum closest to the target
        int closest = 0;
        int closest_diff = Integer.MAX_VALUE;
        for (int e:set){
            if (Math.abs(target - e) < closest_diff){
                closest_diff = Math.abs(target - e);
                closest = e;
            }
        }
        return closest;
    }
}
