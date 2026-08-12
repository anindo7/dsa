class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] dag = new ArrayList[numCourses];
        int[] outgoing = new int[numCourses];
        for(int i=0;i<numCourses; i++) {
            dag[i] = new ArrayList();
        }
        for(int[] e: prerequisites) {
            dag[e[1]].add(e[0]);
            outgoing[e[0]]++;
        }
        Queue<Integer> q = new LinkedList();
        for(int i=0;i<numCourses;i++) {
            if(outgoing[i]==0) {
                q.add(i);
            }
        }
        int[] ans = new int[numCourses];
        int i=0;
        while(!q.isEmpty()) {
            int cv = q.poll();
            for(int v: dag[cv]) {
                outgoing[v]--;
                if(outgoing[v]==0) {
                    q.add(v);
                }
            }
            ans[i++] = cv;
        }
        int[] empty = {};
        return i == numCourses? ans : empty;
    }
}