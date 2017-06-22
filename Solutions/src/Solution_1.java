import java.util.HashMap;
import java.util.Map;

/**
 * Created by huajian_messi on 2017/6/21.
 */
public class Solution_1 {
    public int[] twoSum(int[] nums, int target) {
        int[] temp=new int[2];
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                temp[0]=map.get(target-nums[i]);
                temp[1]=i;
                break;
            }else{
                map.put(nums[i],i);
            }
        }
        return temp;
    }
}
