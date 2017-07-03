/**
 * Created by huajian_messi on 2017/7/3.
 * 将根号以下的存到Set中，遍历查找
 */
public class Solution_633 {
    public boolean judgeSquareSum(int c) {
        int n = (int) Math.sqrt(c) + 1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= n; i++) {
            set.add(i * i);
        }
        for (int i = 0; i <= n; i++) {
            if (set.contains(c - i * i))
                return true;
        }

        return false;
    }
}
