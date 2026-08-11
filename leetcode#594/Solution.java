class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> cc = new HashMap();
        for(int i=0;i<nums.length;i++) {
            if(!cc.containsKey(nums[i])) {
                cc.put(nums[i], 1);
            } else {
                cc.put(nums[i], cc.get(nums[i]) + 1);
            }
        }
        int ans = 0;
        for(int i : cc.keySet()) {
            if(cc.containsKey(i+1)) {
                ans = Math.max(ans, cc.get(i) + cc.get(i+1));
            }
        }
        return ans;
    }
}