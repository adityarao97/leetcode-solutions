class Solution {
    
    private boolean firstHouse = false;

    private int recursiveMaxSum(int idx, int[] nums, int[] dp){
        if(idx==0)
            return (firstHouse) ? nums[0] : 0;
        if(idx<0)
            return 0;
        if(dp[idx]!=-1)
            return dp[idx];
        int pick = nums[idx] + recursiveMaxSum(idx - 2, nums, dp);
        int notPick = recursiveMaxSum(idx - 1, nums, dp);
        return dp[idx] = Math.max(pick, notPick);
    }

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        for(int i=0; i<nums.length; i++)
            dp[i] = -1;  
        firstHouse = true;
        int a = recursiveMaxSum(nums.length - 2, nums, dp);
        for(int i=0; i<nums.length; i++)
            dp[i] = -1;  
        firstHouse = false;
        int b = recursiveMaxSum(nums.length - 1, nums, dp);
        return Math.max(a, b);
    }
}