import java.util.*;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();

        int[][] dp = new int[n][n];

        for(int[] ar : dp){
            Arrays.fill(ar,-1);
        }

        return nn(0,0,triangle,dp,n);

        
    }

    public int nn(int i,int j,List<List<Integer>> t,int[][] dp,int n){

        if(i==n-1) return t.get(n-1).get(j);
        
        if(dp[i][j]!=-1) return dp[i][j];

        int down = t.get(i).get(j)+nn(i+1,j,t,dp,n);
        int dig = t.get(i).get(j)+nn(i+1,j+1,t,dp,n);

        return dp[i][j] = Math.min(down,dig);
    }
}
