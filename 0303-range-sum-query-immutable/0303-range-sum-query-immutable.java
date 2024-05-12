class NumArray {

    int[] arr;
    public NumArray(int[] nums) {
        arr = nums;
    }
    
    public int sumRange(int left, int right) {
        int count = 0;
        for(int i=left;i<=right;i++){
            count+=arr[i];
        }
        return count;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */