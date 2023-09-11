import java.util.*;

class Solution {

    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];

        for(int[] ar : dp){

            Arrays.fill(ar,-1);

        }

        return nn(m-1,n-1,dp);
        
    }

    public int nn(int i,int j,int[][] dp){

        if(i<0 || j<0) return 0;

        if(i==0 && j==0) return 1;

        if(dp[i][j]!=-1) return dp[i][j];

        int lf = nn(i,j-1,dp);
        int rf = nn(i-1,j,dp);

        return dp[i][j] = (lf+rf);
    }
}

OR



import java.util.*;

class Solution {


    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];

        

        return nn(m,n,dp);
        
    }

    public int nn(int m,int n,int[][] dp){

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                
                if(i==0 && j==0){
                    dp[i][j] = 1;
                    continue;
                }

                int lf=0,rf=0;

                if(i>0) lf = dp[i-1][j];
                if(j>0) rf = dp[i][j-1];

                dp[i][j] = lf+rf;
            }
        }

        return dp[m-1][n-1];
    }
}
