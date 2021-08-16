class NumArray {
    
    private int[] arr;
    public NumArray(int[] nums) {
        arr = new int[nums.length];
        for (int i=0; i<nums.length; i++){
            arr[i] = nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        int sum = 0;
        for (int i=left; i<=right; i++){
            sum += arr[i];
        }
        return sum;
    }
}
