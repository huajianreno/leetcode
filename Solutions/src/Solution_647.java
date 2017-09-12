/**
 * Created by huajian_messi on 2017/9/7.
 */
public class Solution_647 {
    public int countSubstrings(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
            count++;
        }
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                dp[i - 1][i] = 1;
                count++;
            }
        }
        for (int i = 3; i <= n; i++) {
            for (int j = i - 1; j < n; j++) {
                if (dp[j - i + 2][j - 1] == 1 && s.charAt(j - i + 1) == s.charAt(j)) {
                    dp[j - i + 1][j] = 1;
                    count++;
                }
            }
        }
        return count;
    }
}
