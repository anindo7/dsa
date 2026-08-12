class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] incoming = new int[1001];
        int[] outgoing = new int[1001];
        for(int[] tr: trust) {
            incoming[tr[1]]++;
            outgoing[tr[0]]++;
        }
        int ans = -1;
        for(int i=1;i<n+1;i++) {
            if(incoming[i] == n-1 && outgoing[i] == 0) {
                ans = i;
            }
        }
        return ans;
    }
}