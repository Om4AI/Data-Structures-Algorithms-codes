public class Solution {
    public int divisibleBy60(int[] arr){
        if(arr.length==1) return (arr[0]==0)? 1:0;

        int sum = 0, f=0, gtsix = 0;
        for(int i: arr){
            if(i==0)f = 1;
            if(i>=6) gtsix = 1;
            sum+=i;
        }

        if(arr.length==2){
            return (f==1 && sum%3==0 && gtsix==1)? 1:0;
        }else return (f==1 && sum%3==0)? 1:0;
    }
}
