class Sample implements Comparable<Sample>{
    
    int node,dis;
    Sample(int node,int dis){
        this.node = node;
        this.dis = dis;
    }
    
    public int compareTo(Sample that){
        return this.dis-that.dis;
    }
    
}

class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    
	    // Code Here. 
	    ArrayList<ArrayList<Sample>> adj = new ArrayList<>();
	    
	    int[] vis = new int[V];
	    
	    for(int i=0;i<V;i++){
	        adj.add(new ArrayList<Sample>());
	    }
	    for(int i=0;i<E;i++){
	        int u = edges[i][0];
	        int v = edges[i][1];
	        int wt = edges[i][2];
	        
	        adj.get(u).add(new Sample(v,wt));
	        adj.get(v).add(new Sample(u,wt));
	        
	    }
	    
	    PriorityQueue<Sample> pq = new PriorityQueue<>();
	    
	    int c=0;
	    
	    pq.add(new Sample(0,0));
	    while(pq.size()!=0){
	        int nnode = pq.peek().node;
	        int nwt = pq.peek().dis;
	        pq.poll();
	        
	        if(vis[nnode]==1) continue;
	        vis[nnode]=1;
	        c+=nwt;
	        
	        for(Sample li : adj.get(nnode)){
	            
	            int inode = li.node;
	            int iwt = li.dis;
	            if(vis[inode]==0){
	            pq.add(new Sample(inode,iwt));}
	        }
	        
	    }
	    
	    return c;
	}
}
