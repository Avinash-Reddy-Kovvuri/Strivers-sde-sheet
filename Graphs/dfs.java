

class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        int[] vis = new int[V];
        Queue<Integer> queue = new LinkedList<>();
        vis[0]=1;
        queue.add(0);
        
        while(!queue.isEmpty()){
            
            int cur = queue.poll();
            arr.add(cur);
            for(Integer it : adj.get(cur)){
                if(vis[it]==0){
                    queue.add(it);
                    vis[it] = 1;
                }
            }
        }
        
        return arr;
    }
}
