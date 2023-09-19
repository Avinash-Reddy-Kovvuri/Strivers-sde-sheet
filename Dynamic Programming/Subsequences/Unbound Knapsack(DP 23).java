import java.util.*;

public class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        // Write your code here.
        int[][] dp = new int[n][w+1];

        for(int[] ar : dp){
            Arrays.fill(ar,-1);
        }

        return nn(n-1,w,profit,weight,dp);
    }


    public static int nn(int ind,int w,int[] pro,int[] wei,int[][] dp){

        if(ind==0){

            return ((int)(w/wei[0])*pro[0]);
        }

        if(dp[ind][w]!=-1) return dp[ind][w];
        int notpick = 0+nn(ind-1,w,pro,wei,dp);
        int pic = Integer.MIN_VALUE;
        if(w>=wei[ind]){
            pic = pro[ind]+nn(ind,w-wei[ind],pro,wei,dp);
        }

        return dp[ind][w] = Math.max(notpick,pic);
    }
}
