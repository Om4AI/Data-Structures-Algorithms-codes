// Code by @ Om Mule
// Java Code: Trapping Rain Water (Hard Level LeetCode)

class Solution {
    public static int forward_pass(int lb, int rb, int height[]){
        int water = 0;
        int bpn = 0;
        int i = lb;
        while (bpn == 0 && i<rb){
            int found = 0;
            for (int j=i+1; j<=rb; j++){
                if (height[j] >= height[i]){
                    found = 1;
                    // Calculate inner weights (to subtract)
                    int inner = 0;
                    for (int k=i+1; k<j; k++){inner+=height[k];}
                    // Measure water
                    water += ((height[i] * (j-i-1)) - inner);
                    i = j;
                    break;
                }
            }
            if (found == 0){bpn = 1;}
        }
        if (bpn == 1){
            water += backward_pass(i, rb, height);
        }
        return water;
    } 

    public static int backward_pass(int lb, int rb, int height[]){
        int back_water = 0, i=rb;
        while (i>lb){
            int found = 0;
            for (int j=i-1; j>=lb; j--){
                if (height[j] >= height[i]){
                    found = 1;
                    // Calculate inner weights (to subtract)
                    int inner = 0;
                    for (int k=i-1; k>j; k--){inner+=height[k];}
                    // Measure water
                    back_water += ((height[i] * (i-j-1)) - inner);
                    i = j;
                    break;
                }
            }
        }
        return back_water;
    }



    public int trap(int[] h) {
        int water;
        // No heights case
        if (h.length==0){
            water = 0;
        }
        // Actual Logic
        else{
            // Get Boundaries
            int lb=0, rb=0, lf=0, rf=0, i=0, j=h.length-1;
            // Left Boundary
            while (lf == 0 && i<h.length-1){
                if (h[i+1]<h[i]){
                    lf = 1;
                    lb = i;
                    break;
                }
                else{i++;}
            }
            // Right Boundary
            while (rf == 0 && j>0){
                if (h[j-1]<h[j]){
                    rf = 1;
                    rb = j;
                    break;
                }
                else{j--;}
            }
            // Actual passes between lb & rb
            water = forward_pass(lb, rb, h);
        }
        return water;
    }
}
