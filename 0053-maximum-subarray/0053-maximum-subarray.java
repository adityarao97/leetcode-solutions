class Solution {
    public int maxSubArray(int[] nums) {
        int max_until_now = 0;
        int max_so_far = Integer.MIN_VALUE;
        for(int num: nums){
            max_until_now += num;
            if(max_until_now>max_so_far)
                max_so_far = max_until_now;
            if(max_until_now<0)
                max_until_now = 0;
        }
        return max_so_far;
    }
}