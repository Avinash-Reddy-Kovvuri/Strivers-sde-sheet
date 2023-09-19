import java.util.* ;
import java.io.*; 

public class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

            /* Your class should be named Solution
            * Don't write main().
            * Don't read input, it is passed as function argument.
            * Change in the given tree itself.
            * No need to return or print the output.
            * Taking input and printing output is handled automatically.
            */

            // int n = weight.length;

            int[][] dp = new int[n][maxWeight+1];

            for(int[] arr : dp){
                Arrays.fill(arr,-1);
            }

            return nn(weight,value,n-1,maxWeight,dp);

    }
    public static int nn(int[] wt,int[] val,int ind,int W,int[][] dp){


        if(ind==0){
            if(wt[ind]<=W) return val[ind];
            return 0;
        }

        if(dp[ind][W]!=-1) return dp[ind][W];

        int notpick = 0+nn(wt,val,ind-1,W,dp);

        int pick = Integer.MIN_VALUE;

        if(wt[ind]<=W)
        pick = val[ind]+nn(wt,val,ind-1,W-wt[ind],dp);

        return dp[ind][W]=Math.max(notpick,pick);

    }
}
