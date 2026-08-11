class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> ans = new ArrayList();
        int[] ht = new int[1001];
        int[] ht2 = new int[1001];
        for(int n: nums1) {
            ht[n] = ht[n] + 1;
        }
        for(int n:nums2) {
            ht2[n] = ht2[n] + 1;
        }
        for(int i=0;i<1001;i++) {
            int p = Math.min(ht[i],ht2[i]);
            for(int j=0;j<p;j++) {
                ans.add(i);
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}