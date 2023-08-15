class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        int[] dis = new int[V];
        
        Arrays.fill(dis,100000000);
        dis[S] = 0;
        
        for(int i=0;i<V-1;i++){
            
            for(ArrayList<Integer> li : edges){
                
                int u = li.get(0);
                int v = li.get(1);
                int wt = li.get(2);
                
                if(dis[u]!=100000000 && dis[v]>dis[u]+wt){
                    dis[v] = dis[u]+wt;
                }
            }
            
        }
        for(ArrayList<Integer> li : edges){
                
                int u = li.get(0);
                int v = li.get(1);
                int wt = li.get(2);
                
                if(dis[u]!=100000000 && dis[v]>dis[u]+wt){
                    
                    return new int[]{-1};
                }
            }
            
            return dis;
        
    }
}
