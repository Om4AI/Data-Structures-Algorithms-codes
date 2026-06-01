// Absolute value of (sum + asteroids[i]) is important since the summation might overflow 
// beyond the Integer range

class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        int sum = mass;
        int n = asteroids.length;

        for (int i=0; i<n; i++){
            if (sum == Integer.MAX_VALUE) return true;
            if (sum >= asteroids[i]){
                sum = Math.abs(sum + asteroids[i]);
            }else{
                return false;
            }
        }
        return true;
    }
}
