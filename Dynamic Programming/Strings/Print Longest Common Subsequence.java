import java.util.*;

public class Solution {
    public static String findLCS(int n, int m, String s1, String s2){
        // Write your code here.

        

        int[][] dp = new int[n][m];

        for(int[] ar : dp){
            Arrays.fill(ar,-1);

        }

        int len = nn(n-1,m-1,s1,s2,dp);

        String s="";
        

        for(int i=0;i<len;i++){
            s+='g';
        }
        StringBuilder sss = new StringBuilder(s);
        int i=n,j=m,leng=len-1;

        while(i>0 && j>0){

            if(s1.charAt(i-1)==s2.charAt(j-1)){
                sss.setCharAt(leng,s1.charAt(i-1));
                i = i-1;
                j = j-1;
                leng=leng-1;

            }
            else if(s1.charAt(i-1)>s2.charAt(j-1)){i-=1;}
            else{j-=1;}
        }

        return sss.toString();
    }

    public static int nn(int ind1,int ind2,String s1,String s2,int[][] dp){


        if(ind1<0 || ind2<0) return 0;

        if(s1.charAt(ind1)==s2.charAt(ind2)){
            return dp[ind1][ind2] = 1+nn(ind1-1,ind2-1,s1,s2,dp);
        }

        else{
            return dp[ind1][ind2] = 0+Math.max(nn(ind1-1,ind2,s1,s2,dp),nn(ind1,ind2-1,s1,s2,dp));
        }
    }
}
