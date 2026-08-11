class Solution {
    public void setZeroes(int[][] matrix) {
        boolean[] rm = new boolean[201];
        boolean[] cm = new boolean[201];
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                if(matrix[i][j]==0) {
                    rm[i] = true;
                    cm[j] = true;
                }
            }
        }
        for(int i=0;i<201;i++) {
            if(rm[i]) {
                for(int j=0;j<matrix[0].length;j++) {
                    matrix[i][j]=0;
                }
            }
            if(cm[i]) {
                for(int j=0;j<matrix.length;j++) {
                    matrix[j][i]=0;
                }
            }
        }
    }
}