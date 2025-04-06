class Solution {

    public int numberOfWays(int idx, int[] dp){
        //at 0th index only 1 step is possible
        if(idx == 0) return 1;
        if(idx<0) return 0;
        if(dp[idx]!=-1) return dp[idx];
        //at each step either take 2 step or two steps
        return dp[idx] = numberOfWays(idx - 2, dp) + numberOfWays(idx - 1, dp);
    }

    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        for(int i=0;i<=n;i++){
            dp[i] = -1;
        }
        //top down approach
        return numberOfWays(n, dp);
    }
}