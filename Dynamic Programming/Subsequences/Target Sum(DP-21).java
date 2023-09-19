class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        int n = nums.length;
        int totSum = 0;
        for(int i : nums){
            totSum += i;
        }

        if(totSum-target<0) return 0;

        if((totSum-target)%2==1) return 0;

        int[][] dp = new int[n][((totSum-target)/2)+1];

        for(int[] ar : dp){
            Arrays.fill(ar,-1);
        }

        return nn(n-1,(totSum-target)/2,nums,dp);
        
    }

    public int nn(int ind,int tar,int[] nums,int[][] dp){

        if(ind==0){
            if(tar==0 && nums[0]==0) return 2;

            if(tar==0 || tar==nums[0]) return 1;

            return 0;
        }

        if(dp[ind][tar]!=-1) return dp[ind][tar];

        int notpick = nn(ind-1,tar,nums,dp);

        int pick = 0;
        if(tar>=nums[ind]){
            pick = nn(ind-1,tar-nums[ind],nums,dp);
        }

        return dp[ind][tar] = pick+notpick;
    }
}
