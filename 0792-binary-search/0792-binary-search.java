class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        int mid = (left + right)/2;
        while(left<=right){
            mid = (left +right)/2;
            if(target>nums[mid]){
                left = mid+1;
            }
            else if(target<nums[mid]) {
                right = mid-1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }

}