import java.util.*;
class Disjoint{

    ArrayList<Integer> rank;
    ArrayList<Integer> par;

    Disjoint(int n){
        rank = new ArrayList<>();
        par = new ArrayList<>();

        for(int i=0;i<n;i++){
            rank.add(0);
            par.add(i);
        }
    }

    public int ulp(int node){

        if(node==par.get(node)) return node;

        int kk = ulp(par.get(node));
        par.set(node,kk);
        return kk;
    }

    public void unionByRank(int u,int v){

        int up_u = ulp(u);
        int up_v = ulp(v);

        if(up_u==up_v) return;

        if(rank.get(up_u)>rank.get(up_v)){
            par.set(up_v,up_u);
        }
        else if(rank.get(up_u)<rank.get(up_v)){
            par.set(up_u,up_v);
        }
        else{
            int rk = rank.get(up_u);
            par.set(up_u,up_v);
            rank.set(up_v,rk+1);
        }
    }

}


public class Solution {
    public static int[] numberOfIslandII(int n, int m, int [][]queries, int q) {
        // Write your code here.


        int[][] vis = new int[n][m];

        int[] res = new int[q];

        Disjoint ds = new Disjoint(n*m);

        int val = 0;

        int cnt = 0;

        for(int i=0;i<q;i++){

            int a = queries[i][0];
            int b = queries[i][1];

            if(vis[a][b]==1){

                res[val++] = cnt;
                continue;

            }

            vis[a][b] = 1;
            cnt+=1;

            int[] xx = {0,0,1,-1};
            int[] yy = {1,-1,0,0};
            
            for(int k=0;k<4;k++){

                int ax = a+xx[k];
                int by = b+yy[k];

                if(ax>=0 && by>=0 && ax<n && by<m && vis[ax][by]==1){
                    int nemo = a*m + b;
                    int memo = ax*m + by;
                    if(ds.ulp(nemo) != ds.ulp(memo)){
                        cnt -= 1;
                        ds.unionByRank(nemo, memo);

                    }
                }

            }

            res[val++] = cnt;

        }

        return res;
    }
}
