class Solution {
    public boolean canPlaceFlowers(int[] arr, int num) {
        List<Integer> list = new ArrayList<>();
        int c =0, n = arr.length;
        if(n==1 && arr[0]==0 && num<=1 || num==0) return true;
        else if((n==1 && arr[0]==1) || (n==1 && arr[0]==0 && num>=1)) return false;

        for(int i: arr)list.add(i);
        for(int i=0; i<n; i++){
            if(i==0 && list.get(i)==0){
                if(list.get(i+1)==0){
                    c++;
                    list.set(i, 1);
                }
            }else if(i==n-1){
                if(list.get(i)==0 && list.get(i-1)==0){
                    c++;
                    list.set(i, 1);
                }
            }else{
                if(list.get(i)==0 && list.get(i-1)==0 && list.get(i+1)==0){
                    c++;
                    list.set(i, 1);
                }
            }
        }
        return c>=num;
    }
}