class Solution {
    public int rob(int[] nums) {

        int n = nums.length;

        int[] dp = new int[n];

        Arrays.fill(dp,-1);

        return nn(nums,n-1,dp);
        
    }

    public int nn(int[] nums,int i,int[] dp){

        if(i==0) return nums[i];
        if(i<0) return 0;
        if(dp[i]!=-1) return dp[i];

        int pic = nn(nums,i-2,dp)+nums[i];
        int npic = nn(nums,i-1,dp);

        return dp[i] = Math.max(pic,npic);       
    }
}
