
class Disjoin{

    ArrayList<Integer> rank;
    ArrayList<Integer> par;

    public Disjoin(int n){
        rank = new ArrayList<>(n);
        par = new ArrayList<>(n);
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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        int n = accounts.size();

        Disjoin ds = new Disjoin(n);

        HashMap<String,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String s = accounts.get(i).get(j);

                if(map.containsKey(s)==false){
                    map.put(s,i);
                }
                else{
                    ds.unionByRank(i,map.get(s));
                }
            }
        }
        ArrayList<String>[] merge= new ArrayList[n];

        for(int i=0;i<n;i++){
            merge[i] = new ArrayList<String>();
        }

        for(String it : map.keySet()){

            int id = ds.ulp(map.get(it));
            String ss = it;

            merge[id].add(ss);

        }

        List<List<String>> li = new ArrayList<>();

        for(int i=0;i<n;i++){
            if(merge[i].size()==0) continue;
            Collections.sort(merge[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String it : merge[i]){
                temp.add(it);
            }
            li.add(temp);
        }

        return li;



        
    }
}
