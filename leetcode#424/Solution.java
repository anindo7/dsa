class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] count = new int[26];

        int ans=0;
        int l=0;int r=0;
        int mf=0;
        while(r<n) {
            int c = s.charAt(r) - 'A';
            count[c]++;
            mf = Math.max(mf, count[c]);
            int ws = r-l+1;
            while(ws - mf > k) {
                int c1 = s.charAt(l) - 'A';
                count[c1]--;
                l++;
                ws--;
            }
            ans = Math.max(ans, ws);
            r++;
        }
        return ans;
    }
}