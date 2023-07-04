class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        // code here
        int n = arr.length;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        Arrays.sort(arr);
        
        for(int i=0;i<n;i++){
            
            if(i>0 && arr[i]==arr[i-1]) continue;
            
            for(int j=i+1;j<n;j++){
                
                if(j>i+1 && arr[j]==arr[j-1]) continue;
                    
                    int lo = j+1,hi= n-1;
                    
                    
                    while(hi>lo){
                        
                        long sum=arr[i]+arr[j]+arr[lo]+arr[hi];
                        
                        if(sum==k){
                            
                            ArrayList<Integer> li = new ArrayList<>();
                            li.add(arr[i]);
                            li.add(arr[j]);
                            li.add(arr[lo]);
                            li.add(arr[hi]);
                            
                            res.add(li);
                            
                            while(hi>lo && arr[lo]==arr[lo+1]) lo+=1;
                            
                            while(hi>lo && arr[hi]==arr[hi-1]) hi-=1;
                            
                            lo+=1;
                            hi-=1;
                            
                        }
                        else if(sum>k){
                            hi-=1;
                        }
                        else{
                            lo+=1;
                        }
                    
                    
                    
                }
            }
        }
        
        return res;
    }
}
