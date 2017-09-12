/**
 * Created by huajian_messi on 2017/8/29.
 * 这一题的关键是先计算出矩阵各个点的和值，到时候通过简单点的加减法获得要的值，注意行列为0时的情况
 */
class NumMatrix {
    private int[][] dp;

    public NumMatrix(int[][] matrix) {
        int m=matrix.length;
        if (m==0)
            return ;
        int n=matrix[0].length;
        dp=new int[m+1][n+1];
        dp[0][0]=matrix[0][0];
        for (int i=1;i<n;i++){
            dp[0][i]=dp[0][i-1]+matrix[0][i];
        }
        for (int i=1;i<m;i++){
            dp[i][0]=dp[i-1][0]+matrix[i][0];
        }
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]+matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1==0||col1==0){
            if (row1==0&&col1==0){
                return dp[row2][col2];
            }
            if (row1==0)
                return dp[row2][col2]-dp[row2][col1-1];
            else
                return dp[row2][col2]-dp[row1-1][col2];
        }
        else
            return dp[row2][col2]-dp[row1-1][col2]-dp[row2][col1-1]+dp[row1-1][col1-1];
    }
}
