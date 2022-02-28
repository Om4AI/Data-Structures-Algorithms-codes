class Solution {
    public boolean canJump(int[] arr){
        int t[] = new int[arr.length+1];
        if(arr[0] >=arr.length-1) return true;
        for(int i=0; i<arr.length+1; i++) t[i] = -1;

        return jump(arr,0,t);
    }

    public static boolean jump(int[] arr, int index, int[] t){
        // Base condition
        int vals = arr[index];
        if(index+vals >=arr.length-1) return true;
        if(index == arr.length-1) return true;
        if(vals==0) return false;
        
        // Memoization check
        if(t[index]!=-1) return (t[index]==1)?true: false;

        // Main logic
        boolean can_reach_last = false;
        int i = 1;
        while(i<=vals && can_reach_last==false){
            can_reach_last = can_reach_last||jump(arr,index+i,t);
            i++;
        }
        if(can_reach_last==true){
            t[index] = 1;
        }else t[index] = 0;

        return can_reach_last;
    }
}