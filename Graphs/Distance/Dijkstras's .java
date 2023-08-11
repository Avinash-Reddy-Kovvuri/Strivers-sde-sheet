class Pair implements Comparable<Pair>{
    
    int des,dis;
    Pair(int des,int dis){
        this.des = des;
        this.dis = dis;
    }
    
    public int compareTo(Pair that){
        
        if(this.dis>that.dis) return 1;
        else if(this.dis<that.dis) return -1;
        else return 0;
    }
    
    public String toString(){
        
        return Integer.toString(des);
    }
    
    
    
    
 }

class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        ArrayList<ArrayList<Pair>> adjj = new ArrayList<>();
        
        for(int i=0;i<V;i++){
            adjj.add(new ArrayList<Pair>());
        }
        
        for(int i=0;i<adj.size();i++){
            for(int j=0;j<adj.get(i).size();j++){
                
                int a = adj.get(i).get(j).get(0);
                int b = adj.get(i).get(j).get(1);
                adjj.get(i).add(new Pair(a,b));
            }
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        pq.add(new Pair(S,0));
        
        int[] dis = new int[V];
        
        for(int i=0;i<V;i++){
            dis[i] = Integer.MAX_VALUE;
        }
        
        dis[S] = 0;
        
        while(!pq.isEmpty()){
            
            int node = pq.peek().des;
            int diss = pq.peek().dis;
            
            pq.poll();
            
            for(Pair it : adjj.get(node)){
                
                int cur = it.des;
                int ndis = it.dis;
                if(dis[cur]>dis[node]+ndis){
                    dis[cur] = dis[node]+ndis;
                    pq.add(new Pair(cur,dis[node]+ndis));
                }
            }
        }
        
        for(int i=0;i<V;i++){
            if(dis[i]==Integer.MAX_VALUE) dis[i]=-1;
            
        }
        
        return dis;
        
        
    }
}
