class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        
        int[] vis = new int[V];
        int[] pre = new int[V];
        
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                if(dfs(i,vis,pre,adj)==true) return true;
            }
            
        }
        
        return false;
       
   
    }
    public boolean dfs(int i,int[] vis,int[] pre,ArrayList<ArrayList<Integer>> adj){
        
        vis[i]=1;
        pre[i]=1;
        
        for(int it : adj.get(i)){
            if(vis[it]==0){
                if(dfs(it,vis,pre,adj)==true) return true;
            }
            else if(pre[it]==1) return true;
        }
        
        pre[i]=0;
        
        return false;
    }
}
