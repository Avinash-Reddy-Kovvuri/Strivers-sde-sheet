import java.util.* ;
import java.io.*; 
public class Solution {

	static int mod = (int)(Math.pow(10,9)+7);
	public static int countPartitions(int n, int d, int[] arr) {
		// Write your code here.
		int totSum =0;

		for(int i : arr){
			totSum += i;
		}

		int s2 = totSum-d;
		if(s2<0) return 0;
		if(s2%2==1) return 0;

		int[][] dp = new int[n][(s2/2)+1];

		for(int[] ar : dp){
			Arrays.fill(ar,-1);
		}

		return nn(n-1,s2/2,arr,dp);
		
	}

	public static int nn(int ind,int target,int[] arr,int[][] dp){

		if(ind==0){
			
			if(target==0 && arr[0]==0) return 2;

			if(target==0 || arr[0]==target) return 1;

			return 0;
		}

		if(dp[ind][target]!=-1) return dp[ind][target];

		int notpick = nn(ind-1,target,arr,dp);
		int pick = 0;
		if(target>=arr[ind]){
			pick = nn(ind-1,target-arr[ind],arr,dp);
		}

		return dp[ind][target] = (notpick+pick)%mod;
	}
}
