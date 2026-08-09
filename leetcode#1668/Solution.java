class Solution {
    public int maxRepeating(String sequence, String word) {
        int sl = sequence.length();
        int wl = word.length();

        int start=0;
        int count = 0;
        int ans = 0;
        while(start<sl) {
            int os=start;
            int ws=0;
            while(ws < wl && start < sl && sequence.charAt(start) == word.charAt(ws)) {
                start++;
                ws++;
                if(ws==wl) {
                    count++;
                    ws=0;
                }
            }
            ans = Math.max(ans, count);
            count = 0;
            start = os+1;
        }
        return ans;
    }
}