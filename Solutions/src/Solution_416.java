/**
 * Created by huajian_messi on 2017/9/12.
 * 0-1背包问题
 */
public class Solution_416 {
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return true;
        int total = 0;
        for (int i = 0; i < len; i++) {
            total += nums[i];
        }
        if (total % 2 != 0)
            return false;
        int avg = total / 2;
        int[][] dp = new int[len][avg + 1];
        for (int i = 0; i <= avg; i++) {
            if (i >= nums[0])
                dp[0][i] = nums[0];
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= avg; j++) {
                if (j >= nums[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[len - 1][avg] == avg;
    }
}
