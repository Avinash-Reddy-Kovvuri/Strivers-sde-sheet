class Sample{

    int time,des;
    Sample(int time,int des){
        this.time = time;
        this.des = des;
    }

}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        int[] dis = new int[n+1];

        for(int i=0;i<=n;i++){
            dis[i]=Integer.MAX_VALUE;
        }

        ArrayList<ArrayList<Sample>> adj = new ArrayList<>();

        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<Sample>());
        }

        for(int i=0;i<times.length;i++){
            int a = times[i][0];
            int b = times[i][1];
            int t = times[i][2];
            adj.get(a).add(new Sample(t,b));
            
        }
        Queue<Sample> q = new LinkedList<>();

        q.add(new Sample(0,k));
        dis[k]=0;

        while(!q.isEmpty()){
            int ti = q.peek().time;
            int dest = q.peek().des;
            q.poll();

            for(Sample it : adj.get(dest)){

                int nt = it.time;
                int ndest = it.des;

                if(dis[ndest]>dis[dest]+nt){

                dis[ndest] = dis[dest]+nt;
                q.add(new Sample(nt,ndest));}

            }
        }

        int maxi=0;

        for(int i=1;i<=n;i++){
            maxi = Math.max(maxi,dis[i]);
            if(dis[i]==Integer.MAX_VALUE) return -1;
        }
        return maxi;

        
    }
}
