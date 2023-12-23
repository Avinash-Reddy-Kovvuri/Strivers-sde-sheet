import java.util.HashSet;

public class Solution {
    public static int longestSubarrayWithSumK(int []a, long k) {
        // Write your code here


        int n=a.length;

        int start=0,end=-1;

        int maxlen = 0;
        long currentSum = 0;

        while(start<n){

            while(end+1<n && currentSum+a[end+1]<=k){
                currentSum += a[end+1];
                ++end;
            }
            if(currentSum==k){

                maxlen = Math.max(maxlen,end-start+1);

            }

            currentSum -= a[start];
            start+=1;
        }

        return maxlen;


    }
}
