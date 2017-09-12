/**
 * Created by huajian_messi on 2017/9/9.
 * 思路，一个回文字符序列，若它的减2子序列的最大回文字符数目已知，则可以通过判断两端的字符是否相同来确定该序列的最大回文序列：
 * 若相同，则在子序列的最大值上加上2
 * 若不同，则选取最大的减1子序列的最大回文序列
 * 注意点！！！！！每次判断时一定记得考虑两端不等的情况！！！！！
 */
public class Solution_516 {
    public int longestPalindromeSubseq(String s) {
        int length = s.length();
        if (length == 0)
            return 0;
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }
        for (int i = 0; i < length - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1))
                dp[i][i + 1] = 2;
            else
                dp[i][i + 1] = 1;
        }
        for (int len = 2; len < length; len++) {
            for (int i = 0; i < length - len; i++) {
                int j = i + len;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][length - 1];
    }
}
