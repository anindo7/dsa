class Solution {

    private int calculateProfit(int[] prices,int[] dp, int i, int prev) {
        if(i>=prices.length) {
            return 0;
        }
        if(dp[i]!=-1 && prev == -1) {
            return dp[i];
        }
        if(prev == -1) {
            dp[i] = Math.max(calculateProfit(prices, dp, i+1, prices[i]), calculateProfit(prices, dp, i+1, -1));
        } else if(prices[i]<prev) {
            dp[i] = calculateProfit(prices, dp, i+1, prices[i]);
        } else {
            int profit = prices[i] - prev;
            return Math.max(profit + calculateProfit(prices, dp, i+2, -1), calculateProfit(prices, dp, i+1, prev));
        }
        return dp[i];
    }

    public int maxProfit(int[] prices) {
        int days = prices.length;
        int[] dp = new int[days];
        Arrays.fill(dp,-1);
        int p = calculateProfit(prices,dp, 0, -1);
        return p;
    }
}