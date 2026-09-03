// If you have one odd - You need to make an odd sequence, hence for every even number you need atleast one odd number less than that
class Solution {
    public boolean uniformArray(int[] arr) {
        int even = 0, odd = 0, min_even=Integer.MAX_VALUE, min_odd=Integer.MAX_VALUE;
        for (int i=0; i<arr.length; i++){
            if (arr[i]%2==0){
                even++;
                min_even = Math.min(min_even, arr[i]);
            }
            else{
                odd++;
                min_odd = Math.min(min_odd, arr[i]);
            }
        }
        // If both even & odd numbers exist, then (minimum even number > minimum odd number)
        if (even>0 && odd>0){
            if (min_even > min_odd) return true;
            else return false;
        } else return true;
    }
}
