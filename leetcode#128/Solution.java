class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> st = new HashSet();
        for(int i: nums) {
            st.add(i);
        }
        int ans = 0;
        for(int i: st) {
            if(!st.contains(i-1)) {
                int n = i+1;
                int c=1;
                while(st.contains(n)) {
                    c++;n++;
                }
                ans = Math.max(ans, c);
            }
        }
        return ans;
    }
}