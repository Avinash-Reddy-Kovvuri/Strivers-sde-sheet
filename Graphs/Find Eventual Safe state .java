class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<graph.length;i++){
            adj.add(new ArrayList<Integer>());
        }
        int[] indeg = new int[graph.length];

        for(int i=0;i<graph.length;i++){

            for(int j=0;j<graph[i].length;j++){
                adj.get(graph[i][j]).add(i);
                indeg[i] += 1;
            }
        
        }
        // System.out.println(adj);

        List<Integer> li = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<graph.length;i++){
           
            if(indeg[i]==0) queue.add(i);
        }

        while(!queue.isEmpty()){
            int cur = queue.poll();
            li.add(cur);
            for(int it : adj.get(cur)){
                
                indeg[it] -= 1;
                if(indeg[it]==0){
                    
                    queue.add(it);
                } 
            }
        }

        Collections.sort(li);

        return li;


        
    }
}
