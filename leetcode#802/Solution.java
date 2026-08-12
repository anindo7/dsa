class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] outgoing = new int[n];
        ArrayList<Integer>[] dag = new ArrayList[n];
        Queue<Integer> q = new LinkedList();
        for(int i=0;i<n;i++) {
            dag[i] = new ArrayList();
        }
        for(int i=0;i<n;i++) {
            for(int v: graph[i]) {
                dag[v].add(i);
            }
            outgoing[i] = graph[i].length;
            if(outgoing[i]==0) {
                q.add(i);
            }
        }
        boolean[] safe = new boolean[n];
        while(!q.isEmpty()) {
            int cv = q.poll();
            for(int v: dag[cv]) {
                outgoing[v]--;
                if(outgoing[v]==0) {
                    q.add(v);
                }
            }
            safe[cv] = true;
        }
        List<Integer> ans = new ArrayList();
        for(int i=0;i<n;i++) {
            if(safe[i]){
                ans.add(i);
            }
        }
        return ans;
    }
}