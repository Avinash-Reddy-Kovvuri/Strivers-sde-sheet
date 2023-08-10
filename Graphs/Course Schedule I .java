class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

       ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

       for(int i=0;i<numCourses;i++){
           adj.add(new ArrayList<Integer>());
       }

       for(int i=0;i<prerequisites.length;i++){

           int a = prerequisites[i][0];
           int b = prerequisites[i][1];

           adj.get(b).add(a);

       }

       int[] indeg = new int[numCourses];

       for(int i=0;i<numCourses;i++){
           for(int it : adj.get(i)){
               indeg[it] +=1;
           }
       }

       Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(indeg[i]==0) queue.add(i);
        }

        int cou=0;

        while(!queue.isEmpty()){
            int cur = queue.poll();
            cou+=1;

            for(int it : adj.get(cur)){
                indeg[it] -=1;
                if(indeg[it]==0){
                    queue.add(it);
                }
            }
        }

        if(cou==numCourses) return true;
        return false;

        
    }
}
