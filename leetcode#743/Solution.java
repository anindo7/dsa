class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dis = new int[n];
        Map<Integer, List<int[]>> graph = new HashMap();
        for(int[] e: times) {
            graph.putIfAbsent(e[0], new ArrayList());
            graph.get(e[0]).add(new int[]{e[1], e[2]});
        }

        Arrays.fill(dis, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0] - b[0]));
        dis[k-1]=0;
        pq.offer(new int[]{0,k});
        while(!pq.isEmpty()) {
            int[] cv = pq.remove();
            int s = cv[1];
            int d = cv[0];
            if(graph.containsKey(s)) {
                for(int[] e: graph.get(s)) {
                    int nd = d + e[1];
                    int v = e[0];
                    if(dis[v-1] > nd) {
                        dis[v-1] = nd;
                        pq.offer(new int[]{nd,v});
                    }
                }
            }
        }
        int maxTime=0;
        for(int i=0;i<n;i++) {
            maxTime = Math.max(maxTime, dis[i]);
        }
        return maxTime == Integer.MAX_VALUE? -1 : maxTime;
    }
}