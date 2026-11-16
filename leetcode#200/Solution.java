class Solution {

    void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        int n = grid.length;
        int m = grid[0].length;
        if(i>=n || j>=m || i<0 || j<0) {
            return;
        }
        if(grid[i][j]=='0' || visited[i][j]) {
            return;
        }
        visited[i][j]=true;
        dfs(grid, visited, i+1, j);
        dfs(grid, visited, i, j+1);
        dfs(grid, visited, i-1, j);
        dfs(grid, visited, i, j-1);
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int ans=0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j]=='1' && !visited[i][j]) {
                    ans++;
                    dfs(grid, visited, i, j);
                }
            }
        }
        return ans;
    }
}