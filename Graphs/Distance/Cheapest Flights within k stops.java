class Sample{

    int k,dest,weight;
    Sample(int k,int dest,int weight){
        this.k = k;
        this.weight = weight;
        this.dest = dest;
    }
}


class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[] dis = new int[n];
        for(int i=0;i<n;i++){
            dis[i] = Integer.MAX_VALUE;
        }

        ArrayList<ArrayList<Sample>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Sample>());
        }

        for(int i=0;i<flights.length;i++){
            int a = flights[i][0];
            int b = flights[i][1];
            int c = flights[i][2];
            adj.get(a).add(new Sample(0,b,c));
        }

        Queue<Sample> q = new LinkedList<>();

        dis[src]=0;

        q.add(new Sample(0,src,0));

        while(!q.isEmpty()){
            int cou = q.peek().k;
            int wt = q.peek().weight;
            int des = q.peek().dest;
            q.poll();

            for(Sample it : adj.get(des)){
                int nwt = it.weight;
                int ndes = it.dest;
                if(dis[ndes]>nwt+wt && cou<=k){
                    dis[ndes] = nwt+wt;
                    q.add(new Sample(cou+1,ndes,dis[ndes]));
                }
            }
        }
        if(dis[dst]==Integer.MAX_VALUE) return -1;
        return dis[dst];
        

        
        
    }
}
