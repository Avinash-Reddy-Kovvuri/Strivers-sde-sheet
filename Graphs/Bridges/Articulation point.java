class Solution
{
    //Function to return Breadth First Traversal of given graph.
    
    public int timer = 1;
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        
        int[] mark = new int[V];
        int[] vis = new int[V];
        int[] inst = new int[V];
        int[] low = new int[V];
        
        dfs(0,-1,adj,mark,vis,inst,low);
        
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i=0;i<V;i++){
            if(mark[i]==1){
                res.add(i);
            }
        }
        
        if(res.size()==0){
            res.add(-1);
        }
        
        return res;
        
        
    }
    
   
    
    public void dfs(int node,int par,ArrayList<ArrayList<Integer>> adj,int[] mark,int[] vis,int[] inst,int[] low){
        
        vis[node] = 1;
        inst[node] = low[node] = timer;
        timer+=1;
        int child = 0;
        
        for(int it: adj.get(node)){
            
            if(it==par) continue;
            if(vis[it]==0){
                
                dfs(it,node,adj,mark,vis,inst,low);
                low[node] = Math.min(low[node],low[it]);
                
                
                if(low[it]>=inst[node] && par!=-1){
                    mark[node] = 1;
                }
                child += 1;
            }
            else{
                
                low[node] = Math.min(low[node],inst[it]);
            }
                
            }
            if(child>1 && par==-1) mark[node]=1;
            
        
        }
        
    
}
