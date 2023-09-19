class Solution {
    public int change(int amount, int[] coins) {

        int n=coins.length;

        int[][] dp = new int[n][amount+1];

        for(int[] ar : dp){
            Arrays.fill(ar,-1);
        }

        return nn(n-1,amount,coins,dp);
        
    }

    public int nn(int ind,int tar,int[] coins,int[][] dp){

        if(ind==0){

            if(tar%coins[ind]==0) return 1;

            return 0;
        }

        if(dp[ind][tar]!=-1) return dp[ind][tar];

        int notpick = nn(ind-1,tar,coins,dp);
        int pick = 0;

        if(tar>=coins[ind]){
            pick = nn(ind,tar-coins[ind],coins,dp);
        }

        return dp[ind][tar] = notpick+pick;

    }
}
