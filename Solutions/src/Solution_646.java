import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by huajian_messi on 2017/9/14.
 */
public class Solution_646 {
    public int findLongestChain(int[][] pairs) {
        int length=pairs.length;
        if(length==0)
            return 0;
        Arrays.sort(pairs,(a,b)->(a[1]-b[1]));
        int tail=pairs[0][1];
        int count=1;
        for (int i=0;i<length;i++){
            if(pairs[i][0]>tail){
                count++;
                tail=pairs[i][1];
            }
        }
        return count;
    }
}
