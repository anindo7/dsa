class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> ans = new ArrayList();
        int[] ht = new int[1001];
        for(int n : nums1) {
            ht[n]=1;
        }
        int c=0;
        for(int n: nums2) {
            if(ht[n]==1) {
                ht[n]=2;
            }
        }
        for(int i=0;i<1001;i++) {
            if(ht[i]==2) {
                ans.add(i);
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

}