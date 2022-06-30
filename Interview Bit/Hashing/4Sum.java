import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] arr, int target){
        HashSet<List<Integer>> res = new HashSet<>();
        int n = arr.length;

        // O(n^3) approach
        for(int i=0; i<n-3; i++){
            List<Integer> temp = new ArrayList<>();
            for(int j=i+1; j<n-2; j++){
                temp = new ArrayList<>();
                temp.add(arr[i]);
                temp.add(arr[j]);
                
                int k = 0;
                long k1 = (long)target - (arr[i] + arr[j]);
                if(k1<Integer.MIN_VALUE || k1>Integer.MAX_VALUE) return new ArrayList<>(res);
                else k = (int)k1;
                
                // Final loop with logic of 2Sum
                List<List<Integer>> twosum = twoSum(arr,j+1,k);
                if(twosum.size()>0){
                    for(List<Integer> l: twosum){
                        temp.addAll(l);
                        Collections.sort(temp);
                        res.add(temp);
                        temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        continue;
                    }
                }
            }
        }

        // Sort the inside arrays
        return new ArrayList<>(res);
    }


    public static List<List<Integer>> twoSum(int[] a, int index, int k){
        int arr[] = new int[a.length-index];
        int p= 0;

        // Create arr
        for(int i=index; i<a.length; i++){
            arr[p] = a[i];
            p++; 
        }

        HashSet<Integer> set = new HashSet<>();
        HashSet<List<Integer>> res = new HashSet<>();
        List<Integer> l = new ArrayList();

        for(int i =0; i<arr.length; i++){
            int el = arr[i];
            if(set.contains(el)){
                l.add(k-el);
                l.add(el);
                res.add(l);
                l = new ArrayList<>();
            }else set.add(k-el);
        }
        List<List<Integer>> l1 = new ArrayList<>(res);
        return l1;
    }
}