/**
 * Created by huajian_messi on 2017/6/27.
 * DP；凑试完成，但是还有一个数学方法，验证了只要找到足够多的3，乘积就是最大的
 */
public class Solution_343 {
    public int integerBreak(int n) {
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        int[] tag = new int[n + 1];
        tag[2] = 2;
        tag[3] = 3;
        int max = 0;
        for (int i = 4; i <= n; i++) {
            for (int j = i - 2; j >= 2; j--) {
                if ((tag[j] * tag[i - j]) > max)
                    max = tag[j] * tag[i - j];
            }
            tag[i] = max;
        }
        return tag[n];
    }
}
