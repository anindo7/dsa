class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        long[] dp = new long[n];
        dp[0]=1;
        int pl = primes.length;
        int[] pi = new int[pl];
        for(int i=1;i<n;i++) {
            int mi = pl;
            long mn = Long.MAX_VALUE;
            for(int j=0; j< pl;j++) {
                long cn = primes[j] * dp[pi[j]];
                if(cn < mn) {
                    mn = cn;
                    mi = j;
                }
            }
            dp[i] = mn;
            pi[mi]++;
            if(dp[i]==dp[i-1]) {
                i--;
            }
        }
        return (int) dp[n-1];
    }
}