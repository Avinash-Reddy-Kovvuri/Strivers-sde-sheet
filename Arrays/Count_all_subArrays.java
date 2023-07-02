import java.util.* ;
import java.io.*; 
public class Solution {
    public static int findAllSubarraysWithGivenSum(int arr[], int s) {
        // Write your code here.  
        int n = arr.length,pres=0,cnt=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0;i<n;i++){

            pres += arr[i];

            int rem = pres - s;

            cnt += map.getOrDefault(rem, 0);

            map.put(pres,map.getOrDefault(pres, 0)+1);

        }

        return cnt;  
    }
}
