class Solution {
    class Pair{
        int i,j,k;
        Pair(int i,int j,int k){
            this.i = i;
            this.j = j;
            this.k = k;
        }
    }
    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length,n=mat[0].length;

        int[][] res = new int[m][n];
        int[][] vis = new int[m][n];

        Queue<Pair> queue = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<mat[i].length;j++){
                if(mat[i][j]==0){
                    queue.add(new Pair(i,j,0));
                    vis[i][j] = 1;
                    }
                else{
                    vis[i][j] = 0;

                }
            }
        }
        int[] xx = {0,0,1,-1};
        int[] yy = {1,-1,0,0};
        while(queue.size()!=0){
            Pair q = queue.poll();
            int i = q.i;
            int j = q.j;
            int k = q.k;

            res[i][j] = k;
            
            for(int mo=0;mo<4;mo++){
            int nx = i+xx[mo];
            int ny = j+yy[mo];
            if(nx<0 || ny<0 || nx>m-1 || ny>n-1|| vis[nx][ny]==1){continue;}

                vis[nx][ny] = 1;
                queue.add(new Pair(nx,ny,k+1));
            }
        }

         return res;
        }

        // System.out.println(res[1][1]);

       
        
        
    
        
    
}
