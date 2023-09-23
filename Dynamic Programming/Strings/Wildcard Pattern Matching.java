class Solution {
    public boolean isMatch(String s, String p) {
        int n=s.length(),m=p.length();

        int[][] dp = new int[n][m];

        for(int[] ar : dp){
            Arrays.fill(ar,-1);
        }

        int k = nn(n-1,m-1,s,p,dp);

        if(k==1) return true;
        else return false;
        // return nn(n-1,m-1,s,p,dp) ? true : false;
    }

    public int isAll(String s,int j){

        for(int i=0;i<=j;i++){
            if(s.charAt(i) != '*') return 0;
        }

        return 1;
    }

    public int nn(int i,int j,String s,String p,int[][] dp){

        if(i<0 && j<0) return 1;

        if(i<0 && j>=0) return isAll(p,j);

        if(j<0 && i>=0) return isAll(s,i);

        if(s.charAt(i)==p.charAt(j) || s.charAt(i)=='?' || p.charAt(j)=='?'){

            return dp[i][j] = nn(i-1,j-1,s,p,dp);
        }

        else{

            if(s.charAt(i)=='*'|| p.charAt(j)=='*'){

            int o = nn(i-1,j,s,p,dp),oo=nn(i,j-1,s,p,dp);

            if(o==1 || oo ==1) return dp[i][j] = 1;
            else return dp[i][j] = 0;
            }

            else{
                return dp[i][j] = 0;
            }
        }
    }
}
