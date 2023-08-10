import java.util.*;
public class Solution {
    public static int[] shortestPath(int n, int [][]edges, int src) {
        // Write your code here.

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int i=0;i<edges.length;i++){

                int a = edges[i][0];
                int b = edges[i][1];

                adj.get(a).add(b);
                adj.get(b).add(a);        

        }
        int dis[] = new int[n];
        for(int i=0;i<n;i++){
            dis[i]=Integer.MAX_VALUE;
        }
        dis[src] = 0;
        Queue<Integer> queue = new LinkedList<>();

        queue.add(src);

        while(!queue.isEmpty()){
            int cur = queue.poll();

            for(int it : adj.get(cur)){
                if(dis[cur]+1<dis[it]){
                    dis[it]=1+dis[cur];
                    queue.add(it);
                }
            }
        }
        for(int i=0;i<n;i++){
            if(dis[i]==Integer.MAX_VALUE) dis[i]=-1;
        }

        return dis;


        }

    
}
