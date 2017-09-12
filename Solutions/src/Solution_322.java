/**
 * Created by huajian_messi on 2017/8/28.
 * 要建立一个数组记录sum-1及之前的最小硬币数目，到sum时，就可以去查sum-coin数组值，加上1就是sum的最小硬币数，再在所有coin中选最小的即可
 */
public class Solution_322 {
    public int coinChange(int[] coins, int amount) {
        if (amount==0){
            return 0;
        }
        int[] dp=new int[amount+1];
        int sum=1;
        while(sum<=amount){
            int min=-1;
            for (int coin:coins){
                if(sum>=coin&&dp[sum-coin]!=-1){
                    int temp=dp[sum-coin]+1;
                    min=min<0?temp:(min<temp?min:temp);
                }
            }
            dp[sum]=min;
            sum++;
        }
        return dp[amount];
    }
}
