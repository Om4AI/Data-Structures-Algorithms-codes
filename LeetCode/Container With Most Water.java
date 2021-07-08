class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int max_area = 0;
        int i = 0, j= n-1;
        while (i < j){
            int area = Math.min(height[i], height[j]) * (j-i);
            if (area > max_area){max_area = area;}
          
            // Try to increase the height thus shift the index where height is lesser
            if (height[i] < height[j]) i++;
            else j--;
        }
        return max_area;
    }
}
