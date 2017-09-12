/**
 * Created by huajian_messi on 2017/8/28.
 */
public class Solution_152 {
    public int maxProduct(int[] nums) {
        int length=nums.length;
        int lastmax,lastmin,max;
        lastmax=lastmin=max=nums[0];
        for(int i=1;i<length;i++){
            int tempmax=Math.max(nums[i],Math.max(lastmax*nums[i],lastmin*nums[i]));
            int tempmin=Math.min(nums[i],Math.min(lastmax*nums[i],lastmin*nums[i]));
            lastmax=tempmax;
            lastmin=tempmin;
            max=Math.max(lastmax,max);
        }
        return max;
    }
}
