import java.util.*;

class Solution {
    public String multiply(String n1, String n2){
        int n = n2.length();
        int m = n1.length();
        if(n1.equals("0") || n2.equals("0")) return "0";

        int[] arr = new int[n];
        Arrays.fill(arr, -1);
        arr[n-1] = m-1;
        int carry = 0, ite = m+n-1;
        StringBuffer sb = new StringBuffer();

        while(ite-->0){

            // Multiply the individual numbers
            int sum = 0;
            for(int i=0; i<n; i++){
                if(arr[i]>=0){
                    int index = arr[i];
                    int mul = Character.getNumericValue(n2.charAt(i))* Character.getNumericValue(n1.charAt(index));
                    sum+=mul;
                }
            }
            sum+=carry;
            carry = 0;
            sb.insert(0, String.valueOf(sum%10));
            carry+=sum/10;

            // Modify the arr for next multiplication
            for (int i=0; i<n; i++){
                if(i+1<=n-1 && arr[i]==-1 && arr[i+1]>=0) arr[i] = m-1;
                else if(arr[i]>0) arr[i]--;
                else if(arr[i]==0) arr[i] = -2;
            }
        }
        if(carry>0) sb.insert(0, carry);
        return sb.toString();
    }
}
