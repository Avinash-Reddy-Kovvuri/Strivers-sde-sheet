
class Sample implements Comparable<Sample>{

    int wt,des;
    Sample(int wt,int des){
        this.wt = wt;
        this.des = des;
    }

    public int compareTo(Sample that){
        return this.des - that.des;
    }

}

class Solution {

    static int countPaths(int n, List<List<Integer>> roads) {
        
        
        // Your code here
        
        int[] dis = new int[n];
        ArrayList<ArrayList<Sample>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Sample>());
        }

        for(int i=0;i<roads.size();i++){
            
            int a = roads.get(i).get(0);
            int b = roads.get(i).get(1);
            int w = roads.get(i).get(2);

            adj.get(a).add(new Sample(w,b));
            adj.get(b).add(new Sample(w,a));

        }

        Arrays.fill(dis,Integer.MAX_VALUE);
        int[] ways = new int[n];
        Arrays.fill(ways,0);

        PriorityQueue<Sample> pq = new PriorityQueue<>();
        pq.add(new Sample(0,0));
        dis[0] = 0;
        ways[0]=1;

        int mod = (int)(1e9+7);

        while(!pq.isEmpty()){

            int wt = pq.peek().wt;
            int des = pq.peek().des;
            pq.poll();

            for(Sample it : adj.get(des)){

                int nwt = it.wt;
                int ndes = it.des;

                if(dis[ndes]>wt+nwt){
                    dis[ndes] = wt+nwt;
                    ways[ndes] = ways[des];
                    pq.add(new Sample(wt+nwt,ndes));
                }
                else if(dis[ndes]==wt+nwt){
                    ways[ndes] = (ways[ndes]+ways[des]) % mod;
                }

            }


        }

        return ways[n-1] % mod;
    }
}
