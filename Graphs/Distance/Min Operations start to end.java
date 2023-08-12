import java.util.*;

class Sample{
    int rea,cou;
    Sample(int rea,int cou){
        this.rea = rea;
        this.cou = cou;
    }
}


public class Solution {
    public static int minimumOperations(int n, int start, int end, int []a) {
        // Write your code here

        if(start==end) return 0;

        int[] dis = new int[1000];
        Arrays.fill(dis,Integer.MAX_VALUE);

        Queue<Sample> q = new LinkedList<>();

        q.add(new Sample(start,0));

        int mod = 1000;

        while(!q.isEmpty()){

            int val = q.peek().rea;
            int count = q.peek().cou;
            q.poll();

            for(int i=0;i<a.length;i++){
                int upval = (val * a[i])%mod;
                if(dis[upval]>count+1){
                    dis[upval] = count+1;
                    if(upval==end) return count+1;
                    q.add(new Sample(upval, count+1));   
                }
            }

        }

        return -1;

    }
}
