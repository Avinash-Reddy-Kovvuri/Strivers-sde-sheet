class Solution{
    static List<Integer> nextPermutation(int N, int arr[]){
        // code here
        List<Integer> li = new ArrayList<>();
        
        for(int i=0;i<N;i++){
            li.add(arr[i]);
        }
        
        int ind=-1;
        for(int i=N-2;i>=0;i--){
            if(li.get(i)<li.get(i+1)){
                ind=i;
                break;
            }
        }
        
        if(ind==-1){
            Collections.reverse(li);
            return li;
        }
        
        for(int i=N-1;i>ind;i--){
            if(li.get(i)>li.get(ind)){
                int t=li.get(i);
                li.set(i,li.get(ind));
                li.set(ind,t);
                break;
            }
        }
        
        List<Integer> sub = li.subList(ind+1,N);
        Collections.reverse(sub);
        
        return li;
        
        
    }
}
