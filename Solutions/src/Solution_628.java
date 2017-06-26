import java.util.Arrays;

/**
 * Created by huajian_messi on 2017/6/26.
 * 注意：有负数，要判断最小的两个负数的乘积和倒二倒三整数乘积的大小关系
 */
public class Solution_628 {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length - 1;
        if (nums[0] * nums[1] > nums[n - 1] * nums[n - 2])
            return nums[0] * nums[1] * nums[n];
        return nums[n] * nums[n - 1] * nums[n - 2];
    }
}
