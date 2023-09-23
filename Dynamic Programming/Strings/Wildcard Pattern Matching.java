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



(OR) 

    #Tabulation


 class Solution {
    public boolean isMatch(String s, String p) {
        

        return wildcardMatching(s,p);
        
    }

    public boolean isAllStars(String S1, int i) {

    
    for (int j = 1; j <= i; j++) {
      if (S1.charAt(j - 1) != '*')
        return false;
    }
    return true;
  }

  public boolean wildcardMatching(String S1, String S2) {

    int n = S1.length();
    int m = S2.length();

    boolean dp[][] = new boolean[n + 1][m + 1];
    dp[0][0] = true;

    for (int j = 1; j <= m; j++) {
      dp[0][j] = isAllStars(S2, j);
    }
    for (int i = 1; i <= n; i++) {
      dp[i][0] = isAllStars(S1, i);
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {

        if (S1.charAt(i - 1) == S2.charAt(j - 1) || S1.charAt(i - 1) == '?' || S2.charAt(j - 1) == '?')
          dp[i][j] = dp[i - 1][j - 1];

        else {
          if (S1.charAt(i - 1) == '*' || S2.charAt(j - 1) == '*')
            dp[i][j] = dp[i - 1][j] || dp[i][j - 1];

          else dp[i][j] = false;
        }
      }
    }

    return dp[n][m];
}
}
