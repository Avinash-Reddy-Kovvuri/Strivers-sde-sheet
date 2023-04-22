class Solution{
    //Function to count the frequency of all elements from 1 to N in the array.
    public static void frequencyCount(int arr[], int N, int P)
    {
        // code here
        int[] ar = new int[N];
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=N)
            ar[arr[i]-1]++;
        }
        for(int i=0;i<arr.length;i++){
            arr[i] = ar[i];
        }
        
        
        
        }
    }
