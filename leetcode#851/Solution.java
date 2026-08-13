class Solution {

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        ArrayList<Integer>[] dag = new ArrayList[n];
        int[] outgoing = new int[n];
        for(int i=0;i<n;i++) {
            dag[i] = new ArrayList();
        }
        for(int[] e: richer) {
            dag[e[0]].add(e[1]);
            outgoing[e[1]]++;
        }
        Queue<Integer> q = new LinkedList();
        int[] ans = new int[n];
        for(int i=0;i<n;i++) {
            ans[i]=i;
            if(outgoing[i]==0) {
                q.add(i);
            }
        }
        while(!q.isEmpty()) {
            int cv = q.poll();
            for(int v: dag[cv]) {
                outgoing[v]--;
                if(outgoing[v]==0) {
                    q.add(v);
                }
                if(quiet[ans[cv]] < quiet[ans[v]]) {
                    ans[v] = ans[cv];
                }
            }
        }
        return ans;
    }
}