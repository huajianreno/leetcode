/**
 * Created by huajian_messi on 2017/9/8.
 * 这一题其实就是从第一个数开始，一步一步加上去，关键是题目给了限制条件，和值不会大于1000
 */
public class Solution_494 {
    public int findTargetSumWays(int[] nums, int S) {
        if (S > 1000 || S < -1000)
            return 0;
        int[] dp = new int[3001];
        int n = nums.length;
        dp[nums[0] + 1000]++;
        dp[1000 - nums[0]]++;
        for (int i = 1; i < n; i++) {
            int[] dpt = new int[3001];
            for (int j = 0; j < 2001; j++) {
                if (dp[j] != 0) {
                    dpt[j + nums[i]] += dp[j];
                    dpt[j - nums[i]] += dp[j];
                }
            }
            dp = dpt;
        }
        return dp[S + 1000];
    }
}
