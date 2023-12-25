class Solution {
    public int maxProduct(int[] nums) {

        int maxi = Integer.MIN_VALUE;
        int pre=1,suf=1;
        int n=nums.length;

        for(int i=0;i<n;i++){

            if(pre==0) pre=1;
            if(suf==0) suf=1;

            pre *= nums[i];
            suf *= nums[n-i-1];

            maxi = Math.max(maxi, Math.max(pre,suf));
        }
        return maxi;
        
    }
}
