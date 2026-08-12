class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] parent = new ArrayList[numCourses];
        int[] outgoing = new int[numCourses];
        for(int i=0;i<numCourses;i++) {
            parent[i] = new ArrayList();
        }
        for(int[] e: prerequisites) {
            parent[e[1]].add(e[0]);
            outgoing[e[0]]++;
        }
        Queue<Integer> q = new LinkedList();
        for(int i=0;i<numCourses;i++) {
            if(outgoing[i]==0) {
                q.add(i);
            }
        }
        int c = 0;
        while(!q.isEmpty()) {
            int cv = q.poll();
            for(int v: parent[cv]) {
                outgoing[v]--;
                if(outgoing[v]==0) {
                    q.add(v);
                }
            }
            c++;
        }
        return c == numCourses;
    }
}