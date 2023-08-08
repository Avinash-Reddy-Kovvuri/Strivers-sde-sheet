
class Sample{
    
    int sou,par;
    Sample(int sou,int par){
        this.sou = sou;
        this.par = par;
    }
    
}
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        
        // Code here
        
        int[] vis = new int[V+1];
        for(int i=0;i<V;i++){
            if(vis[i]==0 && detect(i,adj,vis)) return true;
        }
        return false;
    }
    public boolean detect(int s,ArrayList<ArrayList<Integer>> adj,int[] vis){
        
        Queue<Sample> queue  = new LinkedList<>();
        
        queue.add(new Sample(s,-1));
        
        vis[s]=1;
        
        while(!queue.isEmpty()){
            
            Sample cur = queue.poll();
            
            int source = cur.sou;
            int parent = cur.par;
            
            for(int it : adj.get(source)){
                if(vis[it]==0){
                    vis[it]=1;
                    queue.add(new Sample(it,source));
                }
                else if(it != parent) return true;
            }
            
            
        }
        
        return false;
    }
}
