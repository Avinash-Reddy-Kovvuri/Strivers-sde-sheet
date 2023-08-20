class Disjoin{

    ArrayList<Integer> rank;
    ArrayList<Integer> par;

    public Disjoin(int V){
        rank = new ArrayList<>(V);
        par = new ArrayList<>(V);
        for(int i=0;i<V;i++){
            rank.add(1);
            par.add(i);
        }
    }

    public int ulpar(int node){
        if(node == par.get(node)) return node;

        int ans = ulpar(par.get(node));
        par.set(node,ans);
        return ans;
    }

    public void unionByRank(int u,int v){

        int upu = ulpar(u);
        int upv = ulpar(v);
        if(upu == upv) return;
        if(rank.get(upu)>rank.get(upv)){
            par.set(upv,upu);
        }
        else if(rank.get(upu)<rank.get(upv)){
            par.set(upu,upv);
        }
        else{
            int rk = rank.get(upu);
            par.set(upu,upv);
            rank.set(upv,rk+1);
        }
    }
}


class Solution {
    public int makeConnected(int n, int[][] connections) {

        Disjoin ds = new Disjoin(n);

        int extra = 0;

        for(int i=0;i<connections.length;i++){
            int u = connections[i][0];
            int v = connections[i][1];

            if(ds.ulpar(u)==ds.ulpar(v)) extra+=1;
            else{
                ds.unionByRank(u,v);
            }

        }

        int compo = 0;

        for(int i=0;i<n;i++){
            if(ds.par.get(i)==i) compo += 1;
        }
        // System.out.println(extra+" "+compo);
        if(extra>=compo-1) return compo-1;
        return -1;
        
    }
}
