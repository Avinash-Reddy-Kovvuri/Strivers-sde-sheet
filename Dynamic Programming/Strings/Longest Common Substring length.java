public class Solution {
    public static int lcs(String str1, String str2){

        int n1=str1.length(),n2=str2.length();
        // Write your code here.

        int[][] dp = new int[n1+1][n2+1];

        int ans=0;

        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){

                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    int val = 1+dp[i-1][j-1];
                    dp[i][j] = val;
                    ans = Math.max(val,ans);
                }
                else{
                    dp[i][j]=0;
                }
            }
        }

        return ans;
    }

    
}
