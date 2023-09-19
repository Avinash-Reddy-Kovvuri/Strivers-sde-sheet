import java.util.*;
public class Solution {
	public static int cutRod(int price[], int n) {
		// Write your code here.
		int[][] dp = new int[n][n+1];
		for(int[] ar : dp){
			Arrays.fill(ar,-1);
		}

		return nn(n-1,n,price,dp);
	}

	public static int nn(int ind,int n,int[] price,int[][] dp){

		if(ind==0){

			return n*price[0];
		}

		if(dp[ind][n]!=-1) return dp[ind][n];
		int notpick = 0+nn(ind-1,n,price,dp);

		int rodlen = ind+1;

		int pick = 0;

		if(rodlen<=n){

			pick = price[ind]+nn(ind,n-rodlen,price,dp);

		}

		return dp[ind][n] = Math.max(pick,notpick);
	}
}
