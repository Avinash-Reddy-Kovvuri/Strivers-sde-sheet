class Solution {

    class Sample{
        int x,y;
        Sample(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
   
    public int orangesRotting(int[][] grid) {

        int fresh=0;
        Queue<Sample> queue = new LinkedList<>();

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){

                if(grid[i][j]==1){fresh+=1;}
                else if(grid[i][j]==2){
                    queue.add(new Sample(i,j));
                }
            }
        }

        if(fresh==0) return 0;

        int[] xx = {0,0,1,-1};
        int[] yy = {1,-1,0,0};

        int sizb = queue.size();
        int root = 0;
        int timmer = 0;

        while(!queue.isEmpty()){

            int siz = queue.size();
            root += siz;
            for(int i=0;i<siz;i++){

            Sample cur = queue.poll();

            for(int p=0;p<4;p++){
                

                    int a = cur.x+xx[p];
                    int b = cur.y+yy[p];

        if(a<0 || b<0 || a>=grid.length || b>= grid[0].length || grid[a][b]==0 || grid[a][b]==2) continue;

        queue.add(new Sample(a,b));
        grid[a][b]=2;

                
            }


            }

            if(queue.size()!=0){timmer+=1;}
            }

            if((root-sizb)==fresh) return timmer;
            return -1;


        
        
    }
}
