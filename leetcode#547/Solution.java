class Solution {

    private int findParent(int[] parent, int v) {
        if(parent[v]==v) {
            return v;
        }
        parent[v] = findParent(parent, parent[v]);
        return parent[v];
    }

    private void merge(int[] parent, int u, int v) {
        int a = findParent(parent, u);
        int b = findParent(parent, v);
        if(a<b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] parent = new int[n];
        for(int i=0;i<n;i++) {
            parent[i]=i;
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(isConnected[i][j] == 1 && i!= j) {
                    merge(parent, i, j);
                }
            }
        }
        Set<Integer> st = new HashSet();
        for(int i=0;i<n;i++) {
            st.add(findParent(parent, i));
        }
        return st.size();
    }
}