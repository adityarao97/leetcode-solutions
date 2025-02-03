class Solution {
    public int findMin(int[] nums) {
        if(nums[0]<nums[nums.length-1]){
            return nums[0];
        }
        int left = 0, right = nums.length - 1, mid = 0, res = 5001;
        while(left<=right){
            if(nums[left]<nums[right]){
                return Math.min(res, nums[left]);
            }
            mid = (left + right)/2;
            res = Math.min(res, nums[mid]);
            if(nums[mid]>=nums[left]){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return res;
    }
}