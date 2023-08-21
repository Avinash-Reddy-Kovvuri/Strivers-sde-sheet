class Disjoin{
    ArrayList<Integer> rank;
    ArrayList<Integer> par;

    public Disjoin(int n){
        rank = new ArrayList<>(n);
        par = new ArrayList<>(n);
        for(int i=0;i<=n;i++){
            rank.add(0);
            par.add(i);
        }
    }

    public int ulp(int node){
        if(node==par.get(node)) return node;

        int fou = ulp(par.get(node));
        par.set(node,fou);
        return fou;
    }

    public void unionByRank(int u,int v){

        int upu = ulp(u);
        int upv = ulp(v);

        if(upu==upv) return;

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
    public int removeStones(int[][] stones) {

        int maxrow=0,maxcol=0;

        for(int i=0;i<stones.length;i++){
            maxrow = Math.max(maxrow,stones[i][0]);
            maxcol = Math.max(maxcol,stones[i][1]);
        }
        HashMap<Integer,Integer> map = new HashMap<>();

        Disjoin ds = new Disjoin(maxrow+maxcol+1);

        for(int i=0;i<stones.length;i++){

            int u = stones[i][0];
            int v = stones[i][1];

            ds.unionByRank(u,v+maxrow+1);

            map.put(u,1);
            map.put(v+maxrow+1,1);

        }
        int kd = 0;
        for(int oo : map.keySet()){
            if(ds.ulp(oo)==oo){
                    kd += 1;
            }
        }

        return stones.length-kd;
        
    }
}
