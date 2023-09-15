import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        boolean[][] dp = new boolean[n][k+1];

        

        for(int i=0;i<n;i++){
            dp[i][0] = true;
        }

        if(arr[0]<=k)
        dp[0][arr[0]] = true;

        for(int ind=1;ind<n;ind++){
            for(int tar=1;tar<=k;tar++){

                boolean notake=dp[ind-1][tar];
                boolean take = false;
                if(tar>=arr[ind]){
                    take = dp[ind-1][tar-arr[ind]];
                }

                dp[ind][tar] = notake || take;

            }
            
        }

        return dp[n-1][k];

    }

    
}
 OR 


import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        int[][] dp = new int[n+1][k+1];

        for(int[] ar : dp){
            Arrays.fill(ar,-1);
        }

        return nn(n-1,k,arr,dp);

    }

    public static boolean nn(int ind,int target,int[] arr,int[][] dp){

        if(target==0) return true;

        if(ind==0) return target==arr[0];

        if(dp[ind][target]!=-1) return true;

        boolean nottake = nn(ind-1,target,arr,dp);
        boolean take = false;

        if(target>=arr[ind]){
            take = nn(ind-1,target-arr[ind],arr,dp);
        }

        boolean bb = nottake || take;

        if(bb) dp[ind][target] = 0;

        return bb;

    }
}
