/**
 * Created by huajian_messi on 2017/9/8.
 * 这一题还是很有启发性的；
 * 该题的子问题是，在子数组中，先选数的人能比后选数的最大大多少，还原到原问题中，先选数的变成后选数的，原数组先选数的要比后选数的最大大多少呢？
 * 加上顶端值
 */
public class Solution_486 {
    public boolean PredictTheWinner(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n][n];
        for (int i=0;i<n;i++)
            dp[i][i]=nums[i];
        for (int len=1;len<n;len++) {
            for (int i = 0; i + len < n; i++) {
                int j = i + len;
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n-1]>=0;
    }
}
