import java.util.* ;
import java.io.*; 
public class Solution {
    public static int frogJump(int n, int heights[]) {

        // Write your code here..
        int[] dp = new int[n];
        Arrays.fill(dp,-1);

        return inn(n-1,heights,dp);
    }

    public static int inn(int n,int[] heights,int[] dp){

        if(n==0) return 0;
        if(dp[n]!=-1) return dp[n];

        int jumpTwo = Integer.MAX_VALUE;

        int jumpOne = inn(n-1,heights,dp)+Math.abs(heights[n]-heights[n-1]);

        if(n>1){
            jumpTwo = inn(n-2,heights,dp)+Math.abs(heights[n]-heights[n-2]);
        }

        return dp[n] = Math.min(jumpOne,jumpTwo);
    }

}
