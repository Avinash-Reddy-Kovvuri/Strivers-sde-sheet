class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        Stack<Integer> ss = new Stack<>();
        int[] vis = new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                dfs(i,vis,adj,ss);
            }
        }
        
        int[] res = new int[V];
        int oo=0;
        
        while(!ss.isEmpty()){
            res[oo] = ss.pop();
            oo+=1;
            
        }
        return res;
    }
    public static void dfs(int i,int[] vis,ArrayList<ArrayList<Integer>> adj,Stack<Integer> ss){
        
        vis[i]=1;
        for(int it : adj.get(i)){
            if(vis[it]==0){
                dfs(it,vis,adj,ss);
            }
        }
        ss.push(i);
    }
    
}
