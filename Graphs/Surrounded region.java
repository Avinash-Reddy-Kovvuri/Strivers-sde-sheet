class Solution {
    public void solve(char[][] board) {

        int n=board.length,m=board[0].length;

        int[][] vis = new int[n][m];

        for(int i=0;i<n;i++){
            if(vis[i][0]==0 && board[i][0]=='O'){
                dfs(i,0,board,vis);
            }
            if(vis[i][m-1]==0 && board[i][m-1]=='O'){
                dfs(i,m-1,board,vis);
            }
        }

        for(int j=0;j<m;j++){
            if(vis[0][j]==0 && board[0][j]=='O'){
                dfs(0,j,board,vis);
            }
            if(vis[n-1][j]==0 && board[n-1][j]=='O'){
                dfs(n-1,j,board,vis);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }



       
        
    }
    public void dfs(int a,int b,char[][] board,int[][] vis){

        vis[a][b]=1;

        int[] xx = {0,0,1,-1};
        int[] yy = {1,-1,0,0};

        for(int k=0;k<4;k++){
            int x1 = a+xx[k];
            int y1 = b+yy[k];
            if(x1>=0 && x1<board.length && y1>=0 && y1<board[0].length && vis[x1][y1]==0 && board[x1][y1]=='O'){dfs(x1,y1,board,vis);}
        }

    }
}
