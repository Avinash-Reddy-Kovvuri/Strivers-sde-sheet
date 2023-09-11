import java.util.*;

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length,n=obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        for(int[] ar : dp){
            Arrays.fill(ar,-1);
        }
        return nn(m-1,n-1,obstacleGrid,dp);
        
    }
    public int nn(int i,int j,int[][] pa,int[][] dp){

         if(i<0 || j<0) return 0;

        if(pa[i][j]==1) return 0;

        if(i==0 && j==0) return 1;

        if(dp[i][j]!=-1) return dp[i][j];

        int lf = nn(i,j-1,pa,dp);
        int rf = nn(i-1,j,pa,dp);

        return dp[i][j] = (lf+rf);
    }
}
