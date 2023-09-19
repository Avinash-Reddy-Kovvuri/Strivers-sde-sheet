import java.util.* ;
import java.io.*; 
public class Solution {
    public static int minimumElements(int num[], int x) {
        // Write your code here..
        int n = num.length;

        int[][] dp = new int[n][x+1];

        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }

        int ans = nn(n-1,x,num,dp);

        if(ans>=(int)Math.pow(10,9)) return -1;
        return ans;
    }

    public static int nn(int ind,int tar,int[] num,int[][] dp){


        if(ind==0){

            if(tar%num[0]==0) return tar/num[0];

            return (int)Math.pow(10,9);
        }

        if(dp[ind][tar]!=-1) return dp[ind][tar];

        int notpick = 0+nn(ind-1,tar,num,dp);

        int pick = (int)Math.pow(10,9);

        if(tar>=num[ind]){
            pick = 1+nn(ind,tar-num[ind],num,dp);
        }

        return dp[ind][tar] = Math.min(notpick,pick);
    }

}


OR



class Solution {
    public int coinChange(int[] coins, int amount) {

        int n = coins.length;

        int[][] dp = new int[n][amount+1];

        Arrays.sort(coins);

        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0){
                dp[0][i] = (i/coins[0]);
            }
            else{
                dp[0][i] = (int)Math.pow(10,9);
            }

        }

        for(int ind=1;ind<n;ind++){

            for(int tar=0;tar<=amount;tar++){

                 int notpick = 0+dp[ind-1][tar];

                int pick = (int)Math.pow(10,9);

                if(tar>=coins[ind]){
            pick = 1+dp[ind][tar-coins[ind]];
                         }

            dp[ind][tar] = Math.min(notpick,pick);


            }
        }
        int ans = dp[n-1][amount];
        int mod = (int)(Math.pow(10,9));
        if(ans>=mod) return -1;
        return ans;
        
    }

  
}
