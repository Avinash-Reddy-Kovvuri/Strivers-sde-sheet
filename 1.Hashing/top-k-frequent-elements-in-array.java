class Solution {
    public int[] topK(int[] nums, int k) {
        // Code here
        int[] res = new int[k];
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        Comparator<Map.Entry<Integer,Integer>> com = new Comparator<Map.Entry<Integer,Integer>>(){
            public int compare(Map.Entry<Integer,Integer> i,Map.Entry<Integer,Integer> j){
            if(i.getValue()-j.getValue()==0){return j.getKey()-i.getKey();}
            return j.getValue()-i.getValue();
        }
        };
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(com);
            pq.addAll(map.entrySet());
        for(int i=0;i<k;i++){
            Map.Entry<Integer,Integer> p = pq.poll();
            res[i] = p.getKey();
        }
        return res;
        
        
    }
}
