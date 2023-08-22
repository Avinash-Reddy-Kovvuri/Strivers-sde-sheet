class Disjoint{

    ArrayList<Integer> rank;
    ArrayList<Integer> size;
    ArrayList<Integer> par;

    Disjoint(int n){
        rank = new ArrayList<>();
        par = new ArrayList<>();
        size = new ArrayList<>();

        for(int i=0;i<n;i++){
            par.add(i);
            rank.add(0);
            size.add(1);
        }
    }

    public int ulp(int node){

        if(node==par.get(node)) return node;

        int kk = ulp(par.get(node));
        par.set(node,kk);
        return kk;

    }

    public void unionBySize(int u,int v){

        int ulp_u = ulp(u);
        int ulp_v = ulp(v);

        if(ulp_u==ulp_v) return;
        if(size.get(ulp_u)>size.get(ulp_v)){
            par.set(ulp_v,ulp_u);
            size.set(ulp_u, size.get(ulp_u)+size.get(ulp_v));
        }
        else{
            par.set(ulp_u,ulp_v);
            size.set(ulp_v, size.get(ulp_u)+size.get(ulp_v));

        }
    }
}


class Solution {
    public boolean find(int x,int y,int n){

        return x>=0 && y>=0 && x<n && y<n;
    }
    public int swimInWater(int[][] grid) {

        int n=grid.length;

        ArrayList<Integer> li = new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                li.add(i*n+j);
            }
        }

        Collections.sort(li,(a,b)-> grid[a/n][a%n]-grid[b/n][b%n]);

        Disjoint ds = new Disjoint(n*n);
      
        int[] xx = {0,0,1,-1};
        int[] yy = {1,-1,0,0};

        for(int it : li){

            int r = it/n;
            int c = it%n;

            for(int k=0;k<4;k++){
                int nr = r+xx[k];
                int nc = c+yy[k];

                if(find(nr,nc,n) && grid[nr][nc]<=grid[r][c]){
                    ds.unionBySize(it,nr*n+nc);
                }

                if(ds.ulp(0)==ds.ulp((n*n)-1)){
                    return grid[r][c];
                }
            }


        }

        return -1;
        

           
    }
}
