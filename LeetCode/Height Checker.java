class Solution {
    public int heightChecker(int[] heights) {
        int height[] = new int[heights.length];
        int count=0;
        for (int k=0;k<heights.length; k++){
            height[k] = heights[k];
        }
        
        for (int i =0; i<height.length-1; i++){
            for (int j=i+1; j<height.length; j++){
                if (height[i]>height[j]){
                    int t= height[i];
                    height[i] = height[j];
                    height[j] = t;
                }
            }
        }
        
        for (int i=0; i<heights.length; i++){
            if (height[i] != heights[i]){count+=1;}
        }
        
        return count; 
    }
}
