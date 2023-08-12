import java.util.*;

class Sample implements Comparable<Sample>{

    int dis,i,j;
    Sample(int dis,int i,int j){
        this.dis = dis;
        this.i = i;
        this.j = j;
    }

    public int compareTo(Sample that){
        if(this.dis>that.dis) return 1;
        else if(this.dis<that.dis) return -1;
        return 0;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {

        int n=heights.length,m=heights[0].length;

        int[][] dis = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dis[i][j] = Integer.MAX_VALUE;
            }
        }
        dis[0][0] = 0;
        PriorityQueue<Sample> pq = new PriorityQueue<>();
        pq.add(new Sample(0,0,0));

        int[] xx = {0,0,1,-1};
        int[] yy = {1,-1,0,0};

        while(!pq.isEmpty()){
            
            int dist = pq.peek().dis;
            int ni = pq.peek().i;
            int nj = pq.peek().j;
            pq.poll();

            if(ni==n-1 && nj==m-1) return dist;

            for(int op=0;op<4;op++){

                int ai = ni+xx[op];
                int bi = nj+yy[op];

        if(ai>=0 && ai<n && bi>=0 && bi<m){

        int maxi = Math.max(dist,Math.abs(heights[ai][bi]-heights[ni][nj]));

        if(dis[ai][bi]>maxi){
            dis[ai][bi] = maxi;
            pq.add(new Sample(maxi,ai,bi));
        }
        

            }
            }


        }
        // if(dis[n-1][m-1]!=Integer.MAX_VALUE) return dis[n-1][m-1];
        return 0;
        
    }
}
