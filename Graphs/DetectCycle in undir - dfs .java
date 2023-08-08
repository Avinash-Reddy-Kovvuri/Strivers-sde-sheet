class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        
        // Code here
        
        int[] vis = new int[V+1];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                if(dfs(i,-1,adj,vis)) return true;
            }
        }
        return false;
    }
    public boolean dfs(int s,int par,ArrayList<ArrayList<Integer>> adj,int[] vis){
        
            vis[s]=1;
            for(int it : adj.get(s)){
                if(vis[it]==0){
                    vis[it]=1;
                    if(dfs(it,s,adj,vis)) return true;
                }
                else if(par != it) return true;
            }
            
            return false;
        
        
    }
}
