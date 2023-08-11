import java.util.*;
class Pair{
    int val,wt;
    Pair(int val,int wt){
        this.val = val;
        this.wt = wt;
    }
    public String toString(){

        return Integer.toString(val);
    }
}


public class Solution {
    public static int[] shortestPathInDAG(int n, int m, int [][]edges) {
        // Write your code here

        List<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Pair>());
        }

        for(int i=0;i<edges.length;i++){
            
            int u = edges[i][0];
            int v = edges[i][1];
            int wei = edges[i][2];

            adj.get(u).add(new Pair(v,wei));
        }

        // System.out.println(adj);
        // Stack<Integer> st = new Stack<>();
        // int[] vis = new int[n];

        // for(int i=0;i<n;i++){
        //     if(vis[i]==0){
        //         topo(i,vis,adj,st);
        //     }
        // }

        int[] dis = new int[n];

        for(int i=0;i<n;i++){
            dis[i] = Integer.MAX_VALUE;
        }

        dis[0] = 0;
        Queue<Integer> st = new LinkedList<>();
        st.add(0);
        while(!st.isEmpty()){

            int cur = st.poll();

            for(int o=0;o<adj.get(cur).size();o++){
                Pair it = adj.get(cur).get(o);
                int value = it.val;
                int weigh = it.wt;
                if(dis[value]>dis[cur]+weigh){
                    dis[value] = dis[cur]+weigh;
                    st.add(value);
                    
                }
            }

        }
        for(int i=0;i<n;i++){
            if(dis[i]==Integer.MAX_VALUE){dis[i]=-1;}
        }

        return dis;

    }

    public static void topo(int i,int[] vis,List<ArrayList<Pair>> adj,Stack<Integer> st){
        vis[i] = 1;
        for(int o=0;o<adj.get(i).size();o++){
            int iit = adj.get(i).get(o).val;
            if(vis[iit]==0){
                topo(iit,vis,adj,st);
            }
        }
        st.add(i);
    }
}
