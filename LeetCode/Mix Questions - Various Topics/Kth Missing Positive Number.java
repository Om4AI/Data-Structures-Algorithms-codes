class Solution {
    public int findKthPositive(int[] arr, int k) {
        int m = 0, f=0;
        int num = 1;
        for (int i=0; i< arr.length; i++){
            if (arr[i] != num){
                i-=1;
                m+=1;
                if (m == k){
                    f= 1;
                    break;
                }
                num +=1;
            }
            
            
            else{num +=1;}
            
        }
        if (f==0){
            num -=1;
            while (m != k){
                m +=1;
                num+=1;
            }
            return num;
        }
        else{return num;}  
    }
}
