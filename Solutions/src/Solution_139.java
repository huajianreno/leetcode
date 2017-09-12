import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

/**
 * Created by huajian_messi on 2017/8/30.
 */
public class Solution_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet=new HashSet<String>(wordDict);
        int n=s.length();
        boolean[] dp=new boolean[n+1];
        dp[0]=true;
        for(int i=1;i<=n;i++){
            for (int j=0;j<i;j++){
                if (dp[j]&&wordSet.contains(s.substring(j,i))){
                   dp[i]=true;
                }
            }
        }
        return dp[n];
    }
}
