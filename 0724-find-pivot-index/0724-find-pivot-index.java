class Solution {
    public int pivotIndex(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        if(nums.length==2){
            if(nums[1]==0){
                return 0;
            }
            if(nums[0]==0){
                return 1;
            }
        }
        int pivotIndex = 0;
        int leftSum = 0;
        int rightSum = findSum(nums, 1, nums.length-1);
        while(leftSum!=rightSum){
            pivotIndex++;
            if(pivotIndex>nums.length-1 || pivotIndex<=0){
                return -1;
            }
            leftSum = findSum(nums, 0, pivotIndex-1);
            rightSum = findSum(nums, pivotIndex+1, nums.length-1);
        }
        return pivotIndex;
    }

    public int findSum(int[] arr, int left, int right){
        int sum = 0;
        for(int i=left;i<=right;i++){
            sum+=arr[i];
        }
        return sum;
    }
}