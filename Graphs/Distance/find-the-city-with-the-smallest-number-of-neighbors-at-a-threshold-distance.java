class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int[][] adj = new int[n][n];

        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1]; 
            int wt = edges[i][2];
            adj[u][v] = wt;
            adj[v][u] = wt;

        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && adj[i][j]==0){
                    adj[i][j] = 1000000000;
                }
            }
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    adj[i][j] = Math.min(adj[i][j],adj[i][k]+adj[k][j]);
                }
            }
        }
        int res=0,resc=0;
        for(int i=0;i<n;i++){
            int c=0;
            for(int j=0;j<n;j++){
                if(adj[i][j]<=distanceThreshold && i!=j){
                    // System.out.println(i+" : "+j);
                    c+=1;
                }
            }
            if(i==0){resc=c;res=0;}
            if(resc>=c){res = i;resc=c;}
           
        }
        return res;
        
    }
}
