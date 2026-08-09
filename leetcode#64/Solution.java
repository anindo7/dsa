class Solution {
    private static int int_max=999999999;

    private int findMin(int[][] grid, int m, int n, int x, int y,int[][] dp) {
        if(x >= m || y>=n){
            return int_max;
        }
        if(dp[x][y]!=-1) {
            return dp[x][y];
        }

        int l = findMin(grid,m,n,x+1,y,dp);
        int r = findMin(grid,m,n,x,y+1,dp);
        int delta;
        if(l==int_max && r==int_max) {
            delta=0;
        } else if(l==int_max) {
            delta = r;
        } else if(r==int_max) {
            delta = l;
        } else {
            delta = Math.min(l,r);
        }
        dp[x][y] = grid[x][y] + delta;
        return dp[x][y];
    }

    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp = new int[m][n];
        Arrays.stream(dp).forEach(r -> Arrays.fill(r,-1));
        return findMin(grid,m,n,0,0,dp);

    }
}