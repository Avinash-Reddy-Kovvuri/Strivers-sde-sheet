
class Solution {
    public int numDistinct(String s, String t) {

        int n=s.length(),m = t.length();

        int[][] dp = new int[n][m];

        for(int[] ar : dp){
            Arrays.fill(ar,-1);
        }

        return nn(n-1,m-1,s,t,dp);
        
    }

    public int nn(int ind1,int ind2,String s,String t,int[][] dp){

        if(ind2<0) return 1;

        if(ind1<0) return 0;

        if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];

        if(s.charAt(ind1)==t.charAt(ind2)){

            int tryy = nn(ind1-1,ind2-1,s,t,dp);
            int stay = nn(ind1-1,ind2,s,t,dp);

            return dp[ind1][ind2] = tryy+stay;
        }

        else{

            return dp[ind1][ind2] = nn(ind1-1,ind2,s,t,dp);
        }
    }
}
