class Solution{
    //Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int arr[], int n){
        // Your code here
        
        ArrayList<Integer> li = new ArrayList<>();
        int maxi=arr[n-1];
        li.add(maxi);
        
        for(int i=n-2;i>=0;i--){
            maxi = Math.max(maxi,arr[i]);
            if(arr[i]>=maxi){
                li.add(arr[i]);
            }
        }
        
        Collections.reverse(li);
        return li;
    }
}
