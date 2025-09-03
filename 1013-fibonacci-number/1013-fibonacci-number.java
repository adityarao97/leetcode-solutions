class Solution {

    private int recursive(int idx, int[] dp){
        if(idx <= 1) return idx;
        if(dp[idx]!=-1) return dp[idx];
        dp[idx] = recursive(idx - 1, dp) + recursive(idx - 2, dp);
        return dp[idx];
    }

    public int fib(int n) {
        int[] dp = new int[n+1];
        for(int i=0; i<=n; i++)
            dp[i] = -1;
        return recursive(n, dp);
    }
}