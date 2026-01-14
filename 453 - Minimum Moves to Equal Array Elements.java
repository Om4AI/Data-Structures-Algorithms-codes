class Solution {
    public int minMoves(int[] arr) {
        int min_num = arr[0];
        for (int i=0; i<arr.length; i++){
            min_num = Math.min(arr[i], min_num);
        }

        int min_moves = 0;
        for (int i=0; i<arr.length; i++){
            min_moves += arr[i]-min_num;
        }
        return min_moves;
    }
}