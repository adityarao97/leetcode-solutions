class Solution {

    private int minF(int[] cost, int idx, int[] dp){
        //on reaching max index return the cost of it
        if(idx == cost.length - 1) return cost[idx];
        if(idx >= cost.length) return 0;
        if(dp[idx]!=-1) return dp[idx];
        //at each point we want to check cost for one step or two step
        int oneStep = cost[idx] + minF(cost, idx + 1, dp);
        int twoStep = cost[idx] + minF(cost, idx + 2, dp);
        return dp[idx] = Math.min(oneStep, twoStep);
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        for(int i=0; i<=cost.length; i++){
            dp[i] = -1;
        }
        //calculate minimum cost with index as 0
        int indexZero = minF(cost, 0, dp);
        //calculate minimum cost with index as 1
        int indexOne = minF(cost, 1, dp);
        //return min cost between two indices
        return Math.min(indexZero, indexOne);
    }
}