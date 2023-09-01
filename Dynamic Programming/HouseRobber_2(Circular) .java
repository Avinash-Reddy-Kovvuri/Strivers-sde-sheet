class Solution {
    public int rob(int[] nums) {

        int n = nums.length;
        if(n==1) return nums[0];
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);

        int[] without = new int[n-1];
        int[] with = new int[n-1];

        int a=0,b=0;

        for(int i=0;i<n;i++){
            if(i!=0) without[a++] = nums[i];
            if(i!=n-1) with[b++] = nums[i];
        }

        return Math.max(nn(without,n-2,dp1),nn(with,n-2,dp2));
        
    }

    public int nn(int[] nums,int i,int[] dp){

        if(i==0) return nums[i];
        if(i<0) return 0;

        if(dp[i]!=-1) return dp[i];

        int inc = nn(nums,i-2,dp)+nums[i];
        int ninc = nn(nums,i-1,dp)+0;

        return dp[i] = Math.max(inc,ninc);
    }
}
