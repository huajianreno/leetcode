/**
 * Created by huajian_messi on 2017/9/8.
 * 思路就是，每一个数 i 花费 i 次操作肯定能得到，然后每个 i 都向后不断的加 i，也就是 i 的倍数，更改dp的值，因为都是copy i 个之后paste，
 * 多加一个 i，dp值就增加 1，注意，第一次增加要考虑copy也会算1次，别忘了加上（所以count初始值是2）
 */
public class Solution_650 {
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = n + 1;
        }
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i], i);
            int count = 2;
            for (int j = i * 2; j <= n; j += i) {
                dp[j] = Math.min(dp[j], dp[i] + count);
                count++;
            }
        }
        return dp[n];
    }
}
