class Solution {
    //global variable to check if lastHouse is to be considered or which will be decided based on index
    private boolean isLastHouse = false;
    public int maxF(int[] nums, int idx, int[] dp){
        if(idx == 0){
            if (isLastHouse == true){
                return 0;
            }
            else{
                return nums[idx];
            }
        }
        if(idx<0){
            return 0;
        }
        if(dp[idx]!=-1) return dp[idx];
        //pick house on index and calculate the total amount on robbing it and recursively check for adjacent house
        int pick = nums[idx] + maxF(nums, idx - 2, dp);
        //don't pick house on index and calculate the total amount on robbing next one recursively
        int nPick = maxF(nums, idx - 1, dp);
        //store the max value
        return dp[idx] = Math.max(pick, nPick);
    }

    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length + 1];
        for(int i=0;i<=nums.length;i++){
            dp[i] = -1;
        }
        isLastHouse = true;
        //start with last house
        int min1 = maxF(nums, nums.length - 1, dp);
        for(int i=0;i<=nums.length;i++){
            dp[i] = -1;
        }
        isLastHouse = false;
        //start with 2nd last house
        int min2 = maxF(nums, nums.length - 2, dp);
        return Math.max(min1, min2);
    }
}