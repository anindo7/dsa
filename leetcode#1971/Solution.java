class Solution {

    private int findParent(int[] parent, int x) {
        if(x == parent[x]) {
            return x;
        }
        parent[x] = findParent(parent, parent[x]);
        return parent[x];
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

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] parent = new int[n];
        for(int i=0;i<n;i++) {
            parent[i] = i;
        }
        for(int[] e: edges) {
            merge(parent, e[0], e[1]);
        }
        return findParent(parent, source) == findParent(parent, destination);
    }
}