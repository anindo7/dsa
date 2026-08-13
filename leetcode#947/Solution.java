class Solution {
    private int findParent(int[] parent, int x) {
        if(parent[x]==x){
            return x;
        }
        parent[x]=findParent(parent, parent[x]);
        return parent[x];
    }

    private void merge(int[] parent, int u, int v) {
        int a = findParent(parent, u);
        int b = findParent(parent, v);
        if(a<b) {
            parent[b]=a;
        }else {
            parent[a]=b;
        }
    }

    public int removeStones(int[][] stones) {
        int n = stones.length;
        int[] parent = new int[n];
        for(int i=0;i<n;i++) {
            parent[i]=i;
        }
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                if(stones[i][0] == stones[j][0] || stones[i][1]==stones[j][1]) {
                    merge(parent, i, j);
                }
            }
        }
        Set<Integer> st = new HashSet();
        for(int i=0;i<n;i++) {
            st.add(findParent(parent, i));
        }
        return n - st.size();
    }
}