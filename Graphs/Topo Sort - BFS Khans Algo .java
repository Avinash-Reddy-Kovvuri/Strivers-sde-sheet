class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        int[] indeg = new int[V];
        
        for(int i=0;i<V;i++){
            for(int it : adj.get(i)){
                indeg[it] +=1;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0;i<V;i++){
            if(indeg[i]==0){
                queue.add(i);
            }
        }
        
        int[] res = new int[V];
        int id=0;
        
        while(!queue.isEmpty()){
            
            int cur = queue.poll();
            res[id++] = cur;
            
            for(int it : adj.get(cur)){
                indeg[it] -=1;
                if(indeg[it]==0) queue.add(it);
            }
        }
        
        
        return res;
        
        
       
    }
    
    
}
