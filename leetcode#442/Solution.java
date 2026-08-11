class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int[] count = new int[100001];
        for(int n: nums) {
            count[n]++;
        }
        List<Integer> ans = new ArrayList();
        for(int i=1;i<100001;i++) {
            if(count[i]==2) {
                ans.add(i);
            }
        }
        return ans;
    }
}