import java.util.*;

public class Solution {
    public static int minimizeCost(int n, int k, int []height){
        // Write your code here.
        int[] dp = new int[n];
        Arrays.fill(dp,-1);

        return nm(n-1,k,height,dp);
    }
    public static int nm(int n,int k,int[] height,int[] dp){

        if(n==0) return 0;

        if(dp[n]!=-1) return dp[n];

        int jump = Integer.MAX_VALUE;

        for(int i=1;i<=k;i++){
            if(n-i>=0){
                int newjump = nm(n-i,k,height,dp)+Math.abs(height[n]-height[n-i]);
                jump = Math.min(jump,newjump);
                
                }
            
        }

        return dp[n] = jump;
    }
}
