class Solution {
    public boolean canPartition(int[] nums) {

        int s=0;
        for(int a : nums){
            s+=a;
        }
        if(s%2==1) return false;

        int n = nums.length,target=s/2;

        boolean[][] dp = new boolean[n][(s/2)+1];

        

        

        for(int ind=0;ind<n;ind++){
            dp[ind][0] = true;
        }

        if(target>=nums[0]) dp[0][nums[0]] = true;

        for(int ind=1;ind<n;ind++){
            for(int tar=1;tar<=target;tar++){

                boolean nottaken = dp[ind-1][tar];

                boolean taken = false;

                if(nums[ind]<=tar) taken = dp[ind-1][tar-nums[ind]];
                
                 dp[ind][tar] = nottaken || taken;


            }
           
        }

        return dp[n-1][target];


        
    }

    
}
