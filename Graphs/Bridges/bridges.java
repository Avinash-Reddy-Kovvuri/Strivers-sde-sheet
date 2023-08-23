class Solution {

    int timer = 1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++) adj.add(new ArrayList<Integer>());

        for(int i=0;i<connections.size();i++){
            int u = connections.get(i).get(0);
            int v = connections.get(i).get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);

        }

        List<List<Integer>> res = new ArrayList<>();
        int[] inst = new int[n];
        int[] low = new int[n];
        int[] vis = new int[n];

        dfs(0,-1,adj,inst,low,res,vis);

        return res;




        
    }

    public void dfs(int node,int par,List<List<Integer>> adj,int[] inst,int[] low,List<List<Integer>> res,int[] vis){

        vis[node]=1;

        inst[node] = low[node] = timer;
        timer+=1;

        for(int it : adj.get(node)){
            if(it==par) continue;

            if(vis[it]==0){
                dfs(it,node,adj,inst,low,res,vis);

                low[node] = Math.min(low[node],low[it]);

                if(inst[node]<low[it]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(node);
                    temp.add(it);
                    res.add(temp);
                   
                }
            }
            else{
                low[node] = Math.min(low[node],low[it]);
            }
        }

    }
}
