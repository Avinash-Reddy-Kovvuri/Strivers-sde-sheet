class Solution {
    public int minDistance(String word1, String word2) {

        int k = nn(word1,word2);

        return (word1.length()-k)+(word2.length()-k);
        
    }
    public int nn(String s1,String s2){

        int n = s1.length(),m=s2.length();

        int[][] dp = new int[n+1][m+1];

        for(int ind1=1;ind1<=n;ind1++){
            for(int ind2=1;ind2<=m;ind2++){

                if(s1.charAt(ind1-1)==s2.charAt(ind2-1)){
                    dp[ind1][ind2] = 1+dp[ind1-1][ind2-1];
                }
                else{
                    dp[ind1][ind2] = 0+Math.max(dp[ind1][ind2-1],dp[ind1-1][ind2]);
                }
            }
        }

        return dp[n][m];
    }
}
