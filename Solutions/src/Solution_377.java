/**
 * Created by huajian_messi on 2017/9/11.
 * 思路很简单，主要是注意nums[i]的可能会大于target，这样的话，就不能给dp[nums[i]]赋值
 */
public class Solution_377 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        if (nums.length == 0)
            return 0;
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }
        if (min > target)
            return 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= target)
                dp[nums[i]] = 1;
        }
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if ((i - nums[j]) >= 0) {
                    dp[i] = dp[i] + dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}
