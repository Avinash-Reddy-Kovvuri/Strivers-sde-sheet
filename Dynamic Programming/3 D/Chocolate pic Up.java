import java.util.* ;
import java.io.*; 
public class Solution {
	public static int maximumChocolates(int r, int c, int[][] grid) {
		// Write your code here.
		int[][][] dp = new int[r][c][c];

		for(int[][] arr : dp){
			for(int[] op : arr){
				Arrays.fill(op,-1);
			}
		}

		return nn(0,0,c-1,r,c,grid,dp);

	}
	public static int nn(int x,int y1,int y2,int r,int c,int[][] grid,int[][][] dp){


		if(y1<0 || y2<0 || y1>c-1 || y2>c-1) return (int)Math.pow(-10, 9);

		if(dp[x][y1][y2]!=-1) return dp[x][y1][y2];

		if(x==r-1){
			if(y1==y2){
				return grid[x][y1];
			}
			return grid[x][y1]+grid[x][y2];
		}

		int maxi=Integer.MIN_VALUE;

		for(int di=-1;di<=1;di++){

			for(int dj=-1;dj<=1;dj++){

				int ans;

				if(y1==y2){
					ans = grid[x][y1]+nn(x+1,y1+di,y2+dj,r,c,grid,dp);
				}
				else{
					ans = grid[x][y1]+grid[x][y2]+nn(x+1,y1+di,y2+dj,r,c,grid,dp);
				}

				maxi = Math.max(maxi,ans);
			}

		}

		return dp[x][y1][y2] = maxi;


	}
}
