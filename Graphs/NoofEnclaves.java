class Solution {
    public int numEnclaves(int[][] grid) {

        int n=grid.length,m=grid[0].length;

        int[][] vis= new int[n][m];

        for(int i=0;i<n;i++){
            if(vis[i][0]==0 && grid[i][0]==1){
                dfs(i,0,vis,grid);
            }
            if(vis[i][m-1]==0 && grid[i][m-1]==1){
                dfs(i,m-1,vis,grid);
            }
        }

        for(int j=0;j<m;j++){
            if(vis[0][j]==0 && grid[0][j]==1){
                dfs(0,j,vis,grid);
            }
            if(vis[n-1][j]==0 && grid[n-1][j]==1){
                dfs(n-1,j,vis,grid);
            }
        }

        int c=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]==1){
                    c+=1;
                }
            }
        }
        return c;
        
    }
    public void dfs(int a,int b,int[][] vis,int[][] grid){
        vis[a][b]=1;
        
        int[] xx = {0,0,1,-1};
        int[] yy = {1,-1,0,0};

        for(int k=0;k<4;k++){
            int x1 = a+xx[k];
            int y1 = b+yy[k];

            if(x1>=0 && x1<grid.length && y1>=0 && y1<grid[0].length && vis[x1][y1]==0 && grid[x1][y1]==1){
                dfs(x1,y1,vis,grid);
            }
        }
    }
}
