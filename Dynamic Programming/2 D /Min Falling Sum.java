class Solution {
    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;

        int[][] dp = new int[n][n];

        for(int j=0;j<n;j++){
            dp[0][j] = matrix[0][j];
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){

                int down = matrix[i][j] + dp[i-1][j];

                int lf = (int)Math.pow(10,9);
                int rf = (int)Math.pow(10,9);

                if(j-1>=0) lf = matrix[i][j]+dp[i-1][j-1];
                if(j+1<=n-1) rf = matrix[i][j]+dp[i-1][j+1];

                dp[i][j] = Math.min(down,Math.min(lf,rf));
            }
        }

        int res = Integer.MAX_VALUE;

        for(int j=0;j<n;j++){
            res = Math.min(res,dp[n-1][j]);
        }

        return res;

    }
}
