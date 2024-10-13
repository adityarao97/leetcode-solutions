class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1, ans = 5001;
        while(left <= right){
            if(nums[left] < nums[right]){
                return Math.min(ans,nums[left]);
            }
            int mid = (left + right) / 2;
            ans = Math.min(ans, nums[mid]);
            if(nums[mid] >= nums[left]){
                //search in the right array
                left = mid + 1;
            }
            else{
                //search in the left array
                right = mid - 1;
            }
        }
        return ans;
    }
}