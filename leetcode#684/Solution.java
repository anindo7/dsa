class Solution {

    private int findParent(int[] parent, int x) {
        if(parent[x]==x) {
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

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1];
        for(int i=0;i<n;i++) {
            parent[i] = i;
        }
        for(int[] e: edges) {
            if(findParent(parent, e[0]) == findParent(parent, e[1])) {
                return e;
            }
            merge(parent, e[0], e[1]);
        }
        return null;
    }
}