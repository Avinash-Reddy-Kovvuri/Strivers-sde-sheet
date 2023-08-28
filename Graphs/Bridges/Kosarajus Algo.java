class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        int[] vis = new int[V];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                dfs(i,adj,stack,vis);
            }
        }
        
        ArrayList<ArrayList<Integer>> Rev = new ArrayList<>();
        
        for(int i=0;i<V;i++){
            Rev.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<V;i++){
            
            vis[i] = 0;
            for(int it : adj.get(i)){
                
                Rev.get(it).add(i);
            }
        }
        
        int cou = 0;
        
        while(!stack.isEmpty()){
            
            int nn = stack.peek();
            stack.pop();
            
            if(vis[nn]==0){
                cou += 1;
                dfss(nn,Rev,vis);
                
            }
        }
        
        return cou;
    }
    
    public void dfs(int node,ArrayList<ArrayList<Integer>> adj,Stack<Integer> stack,int[] vis){
        
        vis[node] = 1;
        
        for(int it : adj.get(node)){
            
            if(vis[it]==0){
                dfs(it,adj,stack,vis);
            }
        }
        
        stack.add(node);
        
        
    }
    
    public void dfss(int node,ArrayList<ArrayList<Integer>> adj,int[] vis){
        vis[node] = 1;
        
        for(int it : adj.get(node)){
            
            if(vis[it]==0){
                dfss(it,adj,vis);
          
    }
        }
    }
}
