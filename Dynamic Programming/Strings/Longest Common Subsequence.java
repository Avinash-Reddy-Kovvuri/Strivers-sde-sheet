class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        int n1 = text1.length(),n2 = text2.length();

        int[][] dp = new int[n1][n2];

        for(int[] ar : dp){
            Arrays.fill(ar,-1);
        }

        return nn(n1-1,n2-1,text1,text2,dp);
        
    }

    public int nn(int ind1,int ind2,String t1,String t2,int[][] dp){

        if(ind1<0 || ind2<0) return 0;

        if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];

        if(t1.charAt(ind1)==t2.charAt(ind2)) 
        return dp[ind1][ind2] = 1+nn(ind1-1,ind2-1,t1,t2,dp);

        else 
        return dp[ind1][ind2] = 0+Math.max(nn(ind1-1,ind2,t1,t2,dp),nn(ind1,ind2-1,t1,t2,dp));

    }
}
