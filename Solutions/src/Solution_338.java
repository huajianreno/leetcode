/**
 * Created by huajian_messi on 2017/6/26.
 * 数的二进制为 XXXX0 和 XXXX1 ，右移以为获得 XXXX 中 1 的个数，再加上末尾是否为 1 ，即可获得数中有多少个 1
 * 注意：&运算符的优先级比+运算符低，需要加引号
 */
public class Solution_338 {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }
}
