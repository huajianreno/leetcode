/**
 * Created by huajian_messi on 2017/8/28.
 * 如果存在一个n*n的正方形，那么这个正方形最右下角那一块邻接的左上三块应该都属于(n-1)*(n-1)正方形的最右下角部分，所以依此标记；
 * 注意：第一行和第一列单独拿出来进行判断，依此确定max的初始值
 */
public class Solution_221 {
    public int maximalSquare(char[][] matrix) {
        int max=0;
        int m=matrix.length;
        if (m==0)
            return 0;
        int n=matrix[0].length;
        int[][] dp=new int[m][n];
        for (int i=0;i<m;i++){
            dp[m][0]=matrix[i][0]-48;
            if (max==0&&dp[i][0]==1)
                max=1;
        }
        for (int i=0;i<n;i++){
            dp[0][i]=matrix[0][i]-48;
            if (max==0&&dp[0][i]==1)
                max=1;
        }
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                if (matrix[i][j]=='1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    if (dp[i][j]>max)
                        max=dp[i][j];
                }
            }
        }
        return max*max;
    }
}
