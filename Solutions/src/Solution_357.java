/**
 * Created by huajian_messi on 2017/6/26.
 * 注意：要考虑到n位不同是n-1位不同乘上10减去n-1位，而且要考虑到n-1位不同是ok[n-1]-ok[n-2]
 */
public class Solution_357 {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
        int[] ok = new int[n + 1];
        ok[0] = 1;
        ok[1] = 10;
        for (int i = 2; i <= n; i++) {
            ok[i] = (ok[i - 1] - ok[i - 2]) * (10 - (i - 1)) + ok[i - 1];
        }
        return ok[n];
    }
}
