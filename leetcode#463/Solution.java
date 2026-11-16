class Solution {

    private int check(int[][] grid, int i, int j) {
        int n=grid.length;
        int m=grid[0].length;
        if(i<0 || j<0 || i>=n || j>=m) {
            return 1;
        }
        return grid[i][j]==0? 1:0;
    }

    public int islandPerimeter(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int ans=0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j]==1) {
                    ans += check(grid, i-1, j) + check(grid, i+1, j) + check(grid, i, j-1) + check(grid, i, j+1);
                }
            }
        }
        return ans;
    }
}