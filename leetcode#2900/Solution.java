class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> ans = new ArrayList();
        int startSign = groups[0];
        ans.add(words[0]);
        for(int i=1;i<groups.length;i++) {
            if(groups[i]==startSign) {
                continue;
            }
            ans.add(words[i]);
            startSign = groups[i];
        }
        return ans;
    }
}