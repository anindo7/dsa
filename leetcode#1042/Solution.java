class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        Map<Integer, List<Integer>> graph = new HashMap();
        for(int[] e: paths) {
            graph.putIfAbsent(e[0], new ArrayList());
            graph.putIfAbsent(e[1], new ArrayList());
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        int[] ans = new int[n];
        ans[0]=1;
        for(int i=1;i<n;i++) {
            if(ans[i] == 0) {
                int[] color = new int[4];
                if(graph.containsKey(i+1)) {
                    for(int v : graph.get(i+1)) {
                        if(ans[v-1] != 0) {
                            color[ans[v-1]-1]++;
                        }
                    }
                    for(int j=0;j<4;j++) {
                        if(color[j] == 0) {
                            ans[i]=j+1;
                            break;
                        }
                    }
                } else {
                    ans[i]=1;
                }
            }
        }
        return ans;
    }
}