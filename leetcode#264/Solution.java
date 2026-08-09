class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0]=1;

        int i2=0;int i3=0;int i5=0;
        for(int i=1;i<n;i++) {
            int n2 = 2*dp[i2];
            int n3 = 3*dp[i3];
            int n5 = 5*dp[i5];
            dp[i] = Math.min(n2, Math.min(n3,n5));
            if(dp[i]==n2) {
                i2++;
            } else if(dp[i]==n3) {
                i3++;
            } else {
                i5++;
            }
            if(dp[i]==dp[i-1]) {
                i--;
            }
        }
        return dp[n-1];
    }
}