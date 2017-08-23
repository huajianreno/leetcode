/**
 * Created by huajian_messi on 2017/8/22.
 */
public class Solution_64 {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        for(int j=1;j<n;j++){
            grid[0][j]+=grid[0][j-1];
        }
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                int temp=grid[i][j];
                if(j==0){
                    grid[i][j]+=grid[i-1][j];
                }else{
                    grid[i][j]+=grid[i-1][j];
                    if(grid[i][j]>temp+grid[i][j-1]){
                        grid[i][j]=temp+grid[i][j-1];
                    }
                }
            }
        }
        return grid[m-1][n-1];
    }
}
