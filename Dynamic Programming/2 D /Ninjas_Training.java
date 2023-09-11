import java.util.*;

public class Solution {

    public static int ninjaTraining(int n, int points[][]) {

        // Write your code here..
        
        int[] dp = new int[4];
        dp[0] = Math.max(points[0][1],points[0][2]);
        dp[1] = Math.max(points[0][0],points[0][2]);
        dp[2] = Math.max(points[0][1],points[0][0]);
        dp[3] = Math.max(points[0][0],Math.max(points[0][1],points[0][2]));

        for(int day=1;day<n;day++){
            int[] temp = new int[4];
            for(int last=0;last<=3;last++){
                temp[last] = 0;
                
                for(int tt=0;tt<=2;tt++){
                    if(tt!=last){
                        int act = points[day][tt]+dp[tt];
                        temp[last] = Math.max(temp[last],act);
                    }
                }
            }
            dp = temp;
        }

        return dp[3];
        
    }

    

}




OR 




import java.util.*;

public class Solution {

    public static int ninjaTraining(int n, int points[][]) {

        // Write your code here..
        
        int[][] dp = new int[n][4];
        dp[0][0] = Math.max(points[0][1],points[0][2]);
        dp[0][1] = Math.max(points[0][0],points[0][2]);
        dp[0][2] = Math.max(points[0][1],points[0][0]);
        dp[0][3] = Math.max(points[0][0],Math.max(points[0][1],points[0][2]));

        for(int day=1;day<n;day++){
            for(int last=0;last<=3;last++){
                dp[day][last] = 0;
                for(int tt=0;tt<=2;tt++){
                    if(tt!=last){
                        int act = points[day][tt]+dp[day-1][tt];
                        dp[day][last] = Math.max(dp[day][last],act);
                    }
                }
            }
        }

        return dp[n-1][3];
        
    }

    

}
