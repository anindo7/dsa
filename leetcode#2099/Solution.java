class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        PriorityQueue<int[]> pq2 = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        int i=0;
        for(int n: nums) {
            pq.add(new int[]{n,i++});
        }
        int[] ans = new int[k];
        int k1 = k;
        while(k-->0) {
            int[] c = pq.remove();
            pq2.add(new int[]{c[1], c[0]});
        }
        for(int j=0;j<k1;j++) {
            int[] c = pq2.remove();
            ans[j] = c[1];
        }
        return ans;
    }
}