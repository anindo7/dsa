class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int n = friends.length;
        Queue<Integer> q = new LinkedList();
        boolean[] vis = new boolean[n];
        q.add(id);
        vis[id]=true;
        int l = 0;
        int ns = 0; int cs = 1;
        while(l<level && !q.isEmpty()) {
            int cv = q.remove();
            for(int e: friends[cv]) {
                if(!vis[e]) {
                    vis[e]=true;
                    ns++;
                    q.add(e);
                }
            }
            cs--;
            if(cs==0) {
                l++;
                cs = ns;
                ns=0;
            }
        }

        Map<String, Integer> freq = new HashMap();
        while(!q.isEmpty()) {
            int cv = q.remove();
            for(String s: watchedVideos.get(cv)) {
                freq.put(s, freq.getOrDefault(s,0) + 1);
            }
        }

        List<String> ans = new ArrayList(freq.keySet());
        Collections.sort(ans, (a,b) -> {
            if(freq.get(a) == freq.get(b)) {
                return a.compareTo(b);
            }
            return freq.get(a) - freq.get(b);
        });
        return ans;
    }
}