class Solution {

    public int climbStairs(int n) {

        int prev = 1,prev2 = 2;
        if(n==1) return prev;
        int cur=prev;
        for(int i=2;i<=n;i++){
            cur = prev+prev2;
            prev = prev2;
            prev2 = cur;
        }

        return prev;

        
        
    }

    
}
