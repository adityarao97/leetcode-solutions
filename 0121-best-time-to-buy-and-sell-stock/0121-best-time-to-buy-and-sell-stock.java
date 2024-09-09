class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int currentProfit = 0, left = 0, right = 1;
        while(right<prices.length && left<right){
            if(prices[right]>prices[left]){
                currentProfit = prices[right] - prices[left];
                maxProfit = Math.max(currentProfit, maxProfit);
            }
            else{
                left = right;
            }
            right++;
        }
        if(maxProfit<0){
            maxProfit = 0;
        }
        return maxProfit;
    }
}