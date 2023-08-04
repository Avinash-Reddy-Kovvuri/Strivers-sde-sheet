import java.util.*;
public class Solution {
    public static List<Integer> MinimumCoins(int n) {
        // Write your code here.

        List<Integer> res = new ArrayList<Integer>();
        int[] arr = {1,2,5,10,20,50,100,500,1000};
        int l = arr.length;
        for(int i=l-1;i>=0;i--){

            while(n>=arr[i]){
                n-=arr[i];
                res.add(arr[i]);
            }
        }
        return res;
    }
}
