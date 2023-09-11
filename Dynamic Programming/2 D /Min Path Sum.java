import java.util.*;

class Solution {

    
    public int minPathSum(int[][] grid) {

        int m=grid.length,n=grid[0].length;

        int[][] dp = new int[m][n];

        for(int[] ar : dp){
            Arrays.fill(ar,-1);
        }

        return nn(grid,m-1,n-1,dp);


        
    }

    public int nn(int[][] grid,int i,int j,int[][] dp){

        

        if(i<0 || j<0) return (int)Math.pow(10,9);

        if(i==0 && j==0) return grid[0][0];

        if(dp[i][j]!=-1) return dp[i][j];

        int up = grid[i][j]+nn(grid,i-1,j,dp);
        int lef = grid[i][j]+nn(grid,i,j-1,dp);

        return dp[i][j] = Math.min(up,lef);
    }
}
