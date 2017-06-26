/**
 * Created by huajian_messi on 2017/6/26.
 * 动态规划；连续的等差数列，后一个数能够成Slice的个数是前一个数加1
 */
public class Solution_413 {
    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        if (n < 3)
            return 0;
        int[] tag = new int[n];
        int flag = 0;
        int td = A[1] - A[0];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                flag++;
                continue;
            } else {
                if (A[i] - A[i - 1] == td) {
                    flag++;
                    if (flag >= 3) {
                        tag[i] = tag[i - 1] + 1;
                    }
                } else {
                    td = A[i] - A[i - 1];
                    flag = 2;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            count += tag[i];
        }
        return count;
    }
}
